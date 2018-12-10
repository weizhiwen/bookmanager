package cc.wenshixin.action;

import cc.wenshixin.entity.Book;
import cc.wenshixin.service.BookService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class BookAction extends ActionSupport implements ModelDriven<Book> {
    // 模型驱动封装
    private Book book = new Book();
    @Override
    public Book getModel() {
        return book;
    }

    // 属性注入
    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    // 属性封装
    private File cover;
    private String coverFileName;

    public File getCover() {
        return cover;
    }

    public void setCover(File cover) {
        this.cover = cover;
    }

    public String getCoverFileName() {
        return coverFileName;
    }

    public void setCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
    }

    // 转到图书入库页面
    public String toAddPage() {
        return "toAddPage";
    }

    // 添加图书的方法
    public String add() throws IOException {
        if (cover != null) {
            // 将文件转为二进制文件
            book.setBkCover(FileUtils.readFileToByteArray(cover));
        }
        bookService.add(book);
        return "add";
    }

    // 查询图书的方法
    public String list() {
        List<Book> bookList = bookService.findAll();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("bookList", bookList);
        return "list";
    }

    // 转到图书信息修改页面
    public String toEditPage() {
        int bkId = book.getBkId();
        Book b = bookService.findOne(bkId);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("book", b);
        return "toEditPage";
    }

    // 显示图片的方法
    public String showImg() throws IOException {
        int bkId = book.getBkId();
        Book b = bookService.findOne(bkId);
        HttpServletResponse response = ServletActionContext.getResponse();
        ServletOutputStream out =  response.getOutputStream();
        // 测试图片是否正确存入数据库，经测试是正确的
        /*System.out.println(new File("").getAbsolutePath()+"//text.jpg");
        OutputStream out = new FileOutputStream(new File("").getAbsolutePath()+"//text.jpg");*/
        out.write(b.getBkCover());
        out.flush();
        out.close();
        return NONE;
    }


    // 删除图书的方法
    public String delete() {
        int bkId = book.getBkId();
        Book b = bookService.findOne(bkId);
        if (b != null) {
            bookService.delete(b);
        }
        return "delete";
    }

    // 修改图书的方法
    public String edit() throws IOException {
        if (cover != null  && !cover.equals("")) {
            // 将文件转为二进制文件
            book.setBkCover(FileUtils.readFileToByteArray(cover));
        }
        bookService.update(book);
        return "edit";
    }
}
