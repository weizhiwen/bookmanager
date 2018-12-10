package cc.wenshixin.dao;

import cc.wenshixin.entity.Borrow;

import java.util.List;

public interface BorrowDao extends BaseDao<Borrow> {

    List<Borrow> findConditionByUser(Borrow borrow);

    List<Borrow> findConditionByBook(Borrow borrow);

    List<Borrow> findAllNoReturn();
}
