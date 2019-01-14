package info.chen.awsome.cws.persist.dao;

import java.util.List;

import info.chen.awsome.cws.persist.entity.Salary;

public interface SalaryDao {

	List<Salary> getSalariesByEmployeeID(Integer id);
	
}
