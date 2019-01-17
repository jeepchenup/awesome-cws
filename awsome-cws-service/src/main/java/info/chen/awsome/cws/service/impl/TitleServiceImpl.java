package info.chen.awsome.cws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome.cws.persist.dao.TitleDao;
import info.chen.awsome.cws.persist.entity.Title;
import info.chen.awsome.cws.persist.exception.TitleException;
import info.chen.awsome.cws.service.TitleService;

@Service
@Transactional
public class TitleServiceImpl implements TitleService {
	
	@Autowired
	private TitleDao titleDao;

	@Override
	public List<Title> getTitlesByEmployeeID(Integer id) throws TitleException {
		return titleDao.getTitlesByEmployeeID(id);
	}

}
