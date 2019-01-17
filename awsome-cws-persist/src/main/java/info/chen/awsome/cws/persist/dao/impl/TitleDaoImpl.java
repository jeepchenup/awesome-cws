package info.chen.awsome.cws.persist.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import info.chen.awsome.cws.persist.dao.AbstractDao;
import info.chen.awsome.cws.persist.dao.TitleDao;
import info.chen.awsome.cws.persist.entity.Title;
import info.chen.awsome.cws.persist.exception.TitleException;

@Repository("titleDao")
public class TitleDaoImpl extends AbstractDao<Title> implements TitleDao {
	
	private static Logger LOGGER = LoggerFactory.getLogger(TitleDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Title> getTitlesByEmployeeID(Integer id) throws TitleException{
		List<Title> titles = null;
		Query query = getQuery("FROM Title WHERE emp_no=:empNO");
		query.setInteger("empNO", id);
		titles = query.list();
		LOGGER.info("DAO -> Get {} employee's titles: {}", id, titles);
		return titles;
	}

}
