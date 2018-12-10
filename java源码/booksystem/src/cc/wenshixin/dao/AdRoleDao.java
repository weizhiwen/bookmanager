package cc.wenshixin.dao;

import cc.wenshixin.entity.AdRole;

import java.util.List;

public interface AdRoleDao extends BaseDao<AdRole> {

    List<AdRole> findAllNotCondition();
}
