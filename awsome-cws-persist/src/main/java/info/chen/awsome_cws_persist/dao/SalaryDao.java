package info.chen.awsome_cws_persist.dao;

import java.util.List;

import info.chen.awsome_cws_persist.entity.Salary;

public interface SalaryDao {

	List<Salary> getSalariesByEmployeeID(Integer id);
	
}
