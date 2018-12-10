package cc.wenshixin.service;

import cc.wenshixin.dao.UserDao;
import cc.wenshixin.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserService {
    // 属性注入
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(User user) {
        return userDao.login(user);
    }

    public void add(User user) {
        userDao.add(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findOne(int usId) {
        return userDao.findOne(usId);
    }
    public User findOne(String usId) {
        return userDao.findOne(usId);
    }

    public void delete(User u) {
        userDao.delete(u);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public List<User> findAllByCondition(int i) {
        return userDao.findAllCondition(0);
    }

    public List<User> findAllByNotCondition(int i) {
        return userDao.findAllByNotCondition(0);
    }
}
