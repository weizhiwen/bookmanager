package cc.wenshixin.dao;
/**
 * 基础接口类
 * @author 魏志文
 *
 * @param <T> T为任意类型
 */

import java.util.List;

public interface BaseDao<T> {
	//添加
	void add(T t);
	
	//修改
	void update(T t);
	
	//删除
	void delete(T t);
	
	//根据id查询
	T findOne(int id);

	//根据id查询
	T findOne(String id);

	//查询所有
	List<T> findAll();
}
