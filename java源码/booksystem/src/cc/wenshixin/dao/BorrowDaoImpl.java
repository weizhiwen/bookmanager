package cc.wenshixin.dao;

import cc.wenshixin.entity.Borrow;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class BorrowDaoImpl extends BaseDaoImpl<Borrow> implements BorrowDao {
    @Override
    public List<Borrow> findConditionByUser(Borrow borrow) {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        DetachedCriteria criteria = DetachedCriteria.forClass(Borrow.class);
        criteria.add(Restrictions.eq("user", borrow.getUser()));
        List<Borrow> list = (List<Borrow>) hibernateTemplate.findByCriteria(criteria);
        return list;
    }

    @Override
    public List<Borrow> findConditionByBook(Borrow borrow) {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        DetachedCriteria criteria = DetachedCriteria.forClass(Borrow.class);
        criteria.add(Restrictions.eq("book", borrow.getBook()));
        List<Borrow> list = (List<Borrow>) hibernateTemplate.findByCriteria(criteria);
        return list;
    }

    @Override
    public List<Borrow> findAllNoReturn() {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        List<Borrow> list = (List<Borrow>) hibernateTemplate.find("FROM Borrow WHERE hasReturn=?","否");
        return list;
    }
}
