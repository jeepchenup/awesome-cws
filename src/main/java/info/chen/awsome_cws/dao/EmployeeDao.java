package info.chen.awsome_cws.dao;

import java.util.Set;

import info.chen.awsome_cws.entity.Employee;

public interface EmployeeDao {
	
	Employee findEmployeeByEmpID(int id);
	
	Set<Employee> getEmployees();
	
}
