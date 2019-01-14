package info.chen.awsome.cws.service;

import java.util.List;

import info.chen.awsome.cws.persist.entity.Salary;

public interface SalaryService {

	List<Salary> getSalariesByEmployeeID(Integer id);
	
}
