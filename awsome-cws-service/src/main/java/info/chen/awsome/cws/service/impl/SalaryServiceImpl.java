package info.chen.awsome.cws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome.cws.persist.dao.SalaryDao;
import info.chen.awsome.cws.persist.entity.Salary;
import info.chen.awsome.cws.persist.exception.SalaryException;
import info.chen.awsome.cws.service.SalaryService;

@Service
@Transactional
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	private SalaryDao salaryDao;
	
	@Override
	public List<Salary> getSalariesByEmployeeID(Integer id) throws SalaryException {
		return salaryDao.getSalariesByEmployeeID(id);
	}

}
