package info.chen.awsome.cws.persist.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import info.chen.awsome.cws.persist.dao.AbstractDao;
import info.chen.awsome.cws.persist.dao.TitleDao;
import info.chen.awsome.cws.persist.entity.Title;
import info.chen.awsome.cws.persist.exception.TitleException;

@Repository("titleDao")
public class TitleDaoImpl extends AbstractDao<Title> implements TitleDao {
	
	private static final Logger logger = LogManager.getLogger(TitleDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Title> getTitlesByEmployeeID(Integer id) throws TitleException {
		
		if(id == null || id < 0) {
			logger.error("Unvalid Param: {}, Emp ID Must Not Be Null Or Great Than Zero.", id);
			throw new TitleException("Emp ID Must Not Be Null Or Great Than Zero.");
		}
		
		List<Title> titles = null;
		Query query = getQuery("FROM Title WHERE emp_no=:empNO");
		query.setInteger("empNO", id);
		titles = query.list();
		logger.info("DAO -> Get {} employee's titles: {}", id, titles);
		return titles;
	}
}
