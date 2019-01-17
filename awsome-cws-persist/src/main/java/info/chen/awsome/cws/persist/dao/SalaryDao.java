package info.chen.awsome.cws.persist.dao;

import java.util.List;

import info.chen.awsome.cws.persist.entity.Salary;
import info.chen.awsome.cws.persist.exception.SalaryException;

public interface SalaryDao {

	List<Salary> getSalariesByEmployeeID(Integer id) throws SalaryException;
	
}
