package info.chen.awsome_cws_persist.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome_cws_persist.dao.AbstractDao;
import info.chen.awsome_cws_persist.dao.TitleDao;
import info.chen.awsome_cws_persist.entity.Title;

@Repository("titleDao")
@Transactional
public class TitleDaoImpl extends AbstractDao<Title> implements TitleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Title> getTitlesByEmployeeID(Integer id) {
		Query query = getQuery("FROM Title WHERE emp_no=:empNO");
		query.setInteger("empNO", id);
		return query.list();
	}

}
