package info.chen.awsome_cws.dao;


import java.util.List;

import info.chen.awsome_cws.entity.Employee;
import info.chen.awsome_cws.entity.Salary;
import info.chen.awsome_cws.entity.composite_id.SalaryID;

public interface SalaryDao {

	List<Salary> getSalariesByEmployeeID(Integer id);
	
}
