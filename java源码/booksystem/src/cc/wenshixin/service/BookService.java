package cc.wenshixin.service;

import cc.wenshixin.dao.BookDao;
import cc.wenshixin.entity.Book;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BookService {
    // 属性注入
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void add(Book book) {
        bookDao.add(book);
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public Book findOne(int bkId) {
        return bookDao.findOne(bkId);
    }
    public Book findOne(String bkId) {
        return bookDao.findOne(bkId);
    }

    public void delete(Book b) {
        bookDao.delete(b);
    }

    public void update(Book book) {
        bookDao.update(book);
    }
}
