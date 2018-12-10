package cc.wenshixin.dao;

import cc.wenshixin.entity.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {

    User login(User user);

    List<User> findAllCondition(int i);

    List<User> findAllByNotCondition(int i);
}
