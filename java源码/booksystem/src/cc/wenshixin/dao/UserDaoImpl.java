package cc.wenshixin.dao;

import cc.wenshixin.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User login(User user) {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        // 方法1，效率低
        /*List<User> userList = (List<User>) hibernateTemplate.find("FROM User WHERE usId=? AND usPassword=?",user.getUsId(),user.getUsPassword());
        if (userList != null && userList.size() > 0) {
            User u = userList.get(0);
            return u;
        }*/
        // 方法二，查询部分字段，效率高
        String hql = "SELECT new User(usId, usName, usPassword, usStatus, adRole) " +
                "FROM User u WHERE u.usId=? AND u.usPassword=?";
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, user.getUsId());
        query.setParameter(1, user.getUsPassword());
        List<User> userList = query.list();
        if (userList != null && userList.size() > 0) {
            User u = userList.get(0);
            return u;
        }
        return null;
    }

    @Override
    public List<User> findAllCondition(int i) {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        List<User> userList = (List<User>) hibernateTemplate.find("FROM User WHERE adRole.adRoleId=?",0);
        return userList;
    }

    @Override
    public List<User> findAllByNotCondition(int i) {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        List<User> userList = (List<User>) hibernateTemplate.find("FROM User WHERE adRole.adRoleId!=?",0);
        return userList;
    }
}
