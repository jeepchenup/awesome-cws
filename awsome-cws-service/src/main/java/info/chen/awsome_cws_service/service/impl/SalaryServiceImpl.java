package info.chen.awsome_cws_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome_cws_persist.dao.SalaryDao;
import info.chen.awsome_cws_persist.entity.Salary;
import info.chen.awsome_cws_service.service.SalaryService;

@Service
@Transactional
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	private SalaryDao salaryDao;
	
	@Override
	public List<Salary> getSalariesByEmployeeID(Integer id) {
		return salaryDao.getSalariesByEmployeeID(id);
	}

}
