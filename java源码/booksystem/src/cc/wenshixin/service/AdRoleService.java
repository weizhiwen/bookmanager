package cc.wenshixin.service;

import cc.wenshixin.dao.AdRoleDao;
import cc.wenshixin.entity.AdRole;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class AdRoleService {
    // 属性注入
    private AdRoleDao adRoleDao;
    public void setAdRoleDao(AdRoleDao adRoleDao) {
        this.adRoleDao = adRoleDao;
    }

    public List<AdRole> findAll() {
        return adRoleDao.findAll();
    }

    public List<AdRole> findAllNotCondition() {
        return adRoleDao.findAllNotCondition();
    }
}
