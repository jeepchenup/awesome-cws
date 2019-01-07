package info.chen.awsome_cws_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome_cws_persist.dao.TitleDao;
import info.chen.awsome_cws_persist.entity.Title;
import info.chen.awsome_cws_service.service.TitleService;

@Service
@Transactional
public class TitleServiceImpl implements TitleService {
	
	@Autowired
	private TitleDao titleDao;

	@Override
	public List<Title> getTitlesByEmployeeID(Integer id) {
		return titleDao.getTitlesByEmployeeID(id);
	}

}
