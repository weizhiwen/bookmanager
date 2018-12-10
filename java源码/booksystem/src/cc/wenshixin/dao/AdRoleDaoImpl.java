package cc.wenshixin.dao;

import cc.wenshixin.entity.AdRole;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class AdRoleDaoImpl extends BaseDaoImpl<AdRole> implements AdRoleDao {

    @Override
    public List<AdRole> findAllNotCondition() {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        List<AdRole> adRoleList = (List<AdRole>) hibernateTemplate.find("FROM AdRole WHERE adRoleId!=?",0);
        return adRoleList;
    }
}
