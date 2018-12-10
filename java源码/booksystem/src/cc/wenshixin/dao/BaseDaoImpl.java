package cc.wenshixin.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class pClass;
	public BaseDaoImpl() {
		//1.得到当前运行继承类的Class
		Class clazz = this.getClass();
		
		//2.得到运行类的父类参数化类型 BaseDaoImpl<类名>
		Type type = clazz.getGenericSuperclass();
		ParameterizedType ptype = (ParameterizedType) type;
		
		//3.得到实际类型参数<类名>里面的类名
		Type[] types = ptype.getActualTypeArguments();
		Class tclass = (Class) types[0];
		this.pClass = tclass;
	}

	@Override
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public T findOne(int id) {
		return (T) this.getHibernateTemplate().get(pClass, id);
	}

	@Override
	public T findOne(String id) {
		return (T) this.getHibernateTemplate().get(pClass, id);
	}

	@Override
	public List<T> findAll() {
		//使用Class里面的getSimpleName() 得到类的名称
		return (List<T>) this.getHibernateTemplate().find("FROM "+pClass.getSimpleName());
	}

}
