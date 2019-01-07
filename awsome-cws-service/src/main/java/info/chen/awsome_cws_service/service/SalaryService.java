package info.chen.awsome_cws_service.service;

import java.util.List;

import info.chen.awsome_cws_persist.entity.Salary;

public interface SalaryService {

	List<Salary> getSalariesByEmployeeID(Integer id);
	
}
