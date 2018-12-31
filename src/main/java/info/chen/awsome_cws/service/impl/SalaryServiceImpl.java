package info.chen.awsome_cws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome_cws.dao.SalaryDao;
import info.chen.awsome_cws.entity.Salary;
import info.chen.awsome_cws.service.SalaryService;

@Service("salaryService")
@Transactional
public class SalaryServiceImpl implements SalaryService {
	
	@Autowired
	SalaryDao salaryDao;

	@Override
	public List<Salary> getSalariesByEmployeeID(Integer id) {
		List<Salary> salaries = salaryDao.getSalariesByEmployeeID(id);
		System.out.println(salaries.get(0).getEmployee());
		return salaries;
	}

}
