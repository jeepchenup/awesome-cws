package info.chen.awsome.cws.persist.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<T extends Serializable> {

	@Autowired
	private SessionFactory sessionFactory;
	
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * QBC
	 * @return
	 */
	protected Criteria getCriteria() {
		return getSession().createCriteria(persistentClass);
	}
	
	/**
	 * HQL
	 * @param HQL
	 * @return
	 */
	protected Query getQuery(String HQL) {
		return getSession().createQuery(HQL);
	}
	
	public void persistEntity(T entity) {
		getSession().save(entity);
	}
	
	public void updateEntity(T entity) {
		getSession().update(entity);
	}
	
	public void deleteEntity(T entity) {
		getSession().delete(entity);
	}
	
}
