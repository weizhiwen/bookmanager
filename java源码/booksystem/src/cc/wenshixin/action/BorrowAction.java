package cc.wenshixin.action;

import cc.wenshixin.entity.Book;
import cc.wenshixin.entity.Borrow;
import cc.wenshixin.entity.RdType;
import cc.wenshixin.entity.User;
import cc.wenshixin.service.BookService;
import cc.wenshixin.service.BorrowService;
import cc.wenshixin.service.RdTypeService;
import cc.wenshixin.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

public class BorrowAction extends ActionSupport implements ModelDriven<Borrow>{
    // 模型驱动封装
    private Borrow borrow = new Borrow();

    @Override
    public Borrow getModel() {
        return borrow;
    }

    // 属性注入
    private BorrowService borrowService;

    public void setBorrowService(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    private RdTypeService rdTypeService;

    public void setRdTypeService(RdTypeService rdTypeService) {
        this.rdTypeService = rdTypeService;
    }

    // 转到添加借阅记录的页面
    public String toLendPage() {
        return "toLendPage";
    }

    // 添加借阅记录的方法
    public String lend() {
        HttpServletRequest request = ServletActionContext.getRequest();
        // 1. 判断读者可不可以借，即借书数量是否超过读者类型可借数量
        String usId = borrow.getUser().getUsId();
        User user = userService.findOne(usId);
        int hasCount = user.getUsBorrowCount(); // 读者已借书数量
        RdType rdType = user.getRdType();
        int canCount = rdType.getCanLendCount(); // 读者类型可借书最大数量
        if (hasCount > canCount) {
            request.setAttribute("errormsg", "已超过读者可借书的最大数量！");
            return "lendFail";
        }
        // 2. 判断图书可不可以被借，即图书状态是否为在馆
        int bkId = borrow.getBook().getBkId();
        Book book = bookService.findOne(bkId);
        String bookStatus = book.getBkStatus();
        if (!"在馆".equals(bookStatus)) {
            request.setAttribute("errormsg", "图书不在馆中！");
            return "lendFail";
        }
        // 3. 填写相应的字段，来插入到数据库中
        java.sql.Date dateOut = borrow.getDateOut();
/*        System.out.println("借出的日期为："+dateOut.toString());
        System.out.println("借书人为："+user.getUsName());
        System.out.println("借书人的读者类型为："+user.getRdType().getRdTypeId());
        System.out.println("借书人的读者可借天数为："+user.getRdType().getCanLendDay());*/
        int days = rdType.getCanLendDay();
        java.sql.Date dateReturn = dateAddSomeDay(dateOut, days);
/*        System.out.println("还书的最晚时间为："+dateReturn.toString());*/
        borrow.setDateReturnPlan(dateReturn);
        borrow.setOverDay(0);
        //1borrow.setOverMoneyPlan((float) 0);
        //borrow.setOverMoneyFact((float) 0);
        borrow.setHasReturn("否");
        borrow.setContinueTime((byte) 0);
        //borrow.setOperatorReturn("");
       /* System.out.println("借阅记录序号"+borrow.getBrId());*/
        user.setUsBorrowCount(hasCount+1); // 读者的已借书数量加 1
        book.setBkStatus("借出");
        borrowService.lend(borrow,user,book);
        return "lendSuccess";
    }

    // 根据用户查询的方法
    public String userCondition() {
        if (!"".equals(borrow.getUser().getUsId()) && borrow.getUser().getUsId() != null) {
            List<Borrow> borrowList = borrowService.findConditionByUser(borrow);
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("borrowList", borrowList);
        } else {
            listNoReturn();
        }
        return "userCondition";
    }

    // 根据图书查询的方法
    public String bookCondition() {
        if (!"".equals(borrow.getBook().getBkName()) && borrow.getBook().getBkName() != null) {
            List<Borrow> borrowList = borrowService.findConditionByBook(borrow);
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("borrowList", borrowList);
        } else {
            listNoReturn();
        }
        return "bookCondition";
    }

    // 续借的方法
    public String continueLend() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String brId = borrow.getBrId();
        Borrow br = borrowService.findOne(brId);
        // 1.判断读者可不可以续借，续借的次数有没有超，所借的天数有没有逾期
        String usId = br.getUser().getUsId();
        User user = userService.findOne(usId);
        RdType rdType = user.getRdType();
        int continueTime = rdType.getCanCountTime();
        int hasCountTime = br.getContinueTime();
        if(hasCountTime >= continueTime){
            request.setAttribute("errormsg", "读者续借本书次数已达上限！");
            return "continueLendFail";
        }
        java.sql.Date dateOut = br.getDateOut();
        java.sql.Date returnFact = new java.sql.Date(System.currentTimeMillis()); // 获取当前的日期
        int betweenDays = (int) dateDifference(dateOut, returnFact);
        int days = rdType.getCanLendDay();
        if (betweenDays > days) {
            request.setAttribute("errormsg", "读者借阅本书已逾期！");
            return "continueLendFail";
        }
        java.sql.Date dateReturn = dateAddSomeDay(dateOut, days); // 计算应还书的最晚日期
        br.setContinueTime((byte) (hasCountTime+1));
        br.setDateOut(returnFact);
        br.setDateReturnPlan(dateReturn);
        borrowService.update(br);
        return "continueLendSuccess";
    }

    // 转到还书的页面
    public String toReturnBookPage() {
        String brId = borrow.getBrId();
        Borrow br = borrowService.findOne(brId);
        String usId = br.getUser().getUsId();
        int bkId = br.getBook().getBkId();
        User user = userService.findOne(usId);
        Book book = bookService.findOne(bkId);
        float bkPrice = book.getBkPrice();
        RdType rdType = user.getRdType();
        int days = rdType.getCanLendDay();
        float rate = rdType.getFineRate();
        java.sql.Date dateOut = br.getDateOut();
        java.sql.Date returnFact = new java.sql.Date(System.currentTimeMillis()); // 获取当前的日期
        int betweenDays = (int) dateDifference(dateOut, returnFact);
        if (betweenDays > days) {
            int overDays = betweenDays - days;
            br.setOverDay(overDays);
            float overMoneyPlan = overDays * rate;
            br.setOverMoneyPlan(overMoneyPlan);
        }
        br.setDateReturnFact(returnFact);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("borrow",br);
        request.setAttribute("price",bkPrice);
        return "toReturnBookPage";
    }

    // 读者还书的方法
    public String returnBook() {
        String usId = borrow.getUser().getUsId();
        int bkId = borrow.getBook().getBkId();
        User user = userService.findOne(usId);
        Book book = bookService.findOne(bkId);
        // 1.读者已借书的数量减 1
        int hasLendCount = user.getUsBorrowCount();
        user.setUsBorrowCount(hasLendCount-1);
        // 2.图书的状态设为在馆状态
        book.setBkStatus("在馆");
        // 3.更新数据表
        borrowService.returnBook(borrow, user, book);
        return "returnBook";
    }

    // 续借和还书页面
    public String continueAndReturn() {
        List<Borrow> borrowList = borrowService.findAllNoReturn();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("borrowList", borrowList);
        return "continueAndReturn";
    }

    // 全部借阅记录
    public String list() {
        List<Borrow> borrowList = borrowService.findAll();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("borrowList", borrowList);
        return "list";
    }

    public String listNoReturn() {
        List<Borrow> borrowList = borrowService.findAllNoReturn();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("borrowList", borrowList);
        return "listNoReturn";
    }

    // 日期加几天的计算方法
    public java.sql.Date dateAddSomeDay(java.sql.Date sqlDate, int days){
        // java.sql.Date 转 java.util.Date，java.util.Date 再转 java.sql.Date 返回
        java.util.Date utilDate = sqlDate;
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(utilDate);
        rightNow.add(Calendar.DAY_OF_YEAR,days);
        java.util.Date tempDate = rightNow.getTime();
        java.sql.Date returnDate = new java.sql.Date(tempDate.getTime());
        return returnDate;
    }

    // 日期相减的计算方法
    public long dateDifference(java.sql.Date sqlDate1, java.sql.Date sqlDate2) {
        // TODO: 2017/12/17
        java.util.Date utilDate1 = sqlDate1;
        java.util.Date utilDate2 = sqlDate2;
        long betweenDays = (utilDate2.getTime() - utilDate1.getTime()) / (1000 * 60 * 60 * 24);
        return betweenDays;
    }
}
