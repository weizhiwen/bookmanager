package cc.wenshixin.service;

import cc.wenshixin.dao.RdTypeDao;
import cc.wenshixin.entity.RdType;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RdTypeService {
    // 属性注入
    private RdTypeDao rdTypeDao;
    public void setRdTypeDao(RdTypeDao rdTypeDao) {
        this.rdTypeDao = rdTypeDao;
    }

    public List<RdType> findAll() {
        return rdTypeDao.findAll();
    }

    public RdType findOne(int id) {
        return rdTypeDao.findOne(id);
    }

    public void delete(RdType type) {
        rdTypeDao.delete(type);
    }

    public void add(RdType rdType) {
        rdTypeDao.add(rdType);
    }

    public void update(RdType rdType) {
        rdTypeDao.update(rdType);
    }
}
