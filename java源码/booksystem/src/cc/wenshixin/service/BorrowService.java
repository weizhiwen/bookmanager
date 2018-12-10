package cc.wenshixin.service;

import cc.wenshixin.dao.BookDao;
import cc.wenshixin.dao.BorrowDao;
import cc.wenshixin.dao.UserDao;
import cc.wenshixin.entity.Book;
import cc.wenshixin.entity.Borrow;
import cc.wenshixin.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BorrowService {
    // 属性注入
    private BorrowDao borrowDao;
    public void setBorrowDao(BorrowDao borrowDao) {
        this.borrowDao = borrowDao;
    }
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    private BookDao bookDao;
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void add(Borrow borrow) {
        borrowDao.add(borrow);
    }

    public Borrow findOne(int id) {
        return borrowDao.findOne(id);
    }
    public Borrow findOne(String id) {
        return borrowDao.findOne(id);
    }

    public void update(Borrow borrow) {
        borrowDao.update(borrow);
    }

    public void delete(Borrow b) {
        borrowDao.delete(b);
    }

    public List<Borrow> findAll() {
        return borrowDao.findAll();
    }

    public void lend(Borrow borrow, User user, Book book) {
        // 事务处理
        // 1.记录添加到 borrow 表中
        borrowDao.add(borrow);
        // 2.读者已借书数量加 1
        userDao.update(user);
        // 3.图书状态修改为借出
        bookDao.update(book);
    }

    public void returnBook(Borrow borrow, User user, Book book) {
        // 事务处理
        // 1.记录修改
        borrowDao.update(borrow);
        // 2.读者已借书数量减 1
        userDao.update(user);
        // 3.图书状态修改为在馆
        bookDao.update(book);
    }

    public List<Borrow> findConditionByUser(Borrow borrow) {
        return borrowDao.findConditionByUser(borrow);
    }

    public List<Borrow> findConditionByBook(Borrow borrow) {
        return borrowDao.findConditionByBook(borrow);
    }

    public List<Borrow> findAllNoReturn() {
        return borrowDao.findAllNoReturn();
    }
}
