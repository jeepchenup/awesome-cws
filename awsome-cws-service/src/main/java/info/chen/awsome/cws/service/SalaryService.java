package info.chen.awsome.cws.service;

import java.util.List;

import info.chen.awsome.cws.persist.entity.Salary;
import info.chen.awsome.cws.persist.exception.SalaryException;

public interface SalaryService {

	List<Salary> getSalariesByEmployeeID(Integer id) throws SalaryException;
	
}
