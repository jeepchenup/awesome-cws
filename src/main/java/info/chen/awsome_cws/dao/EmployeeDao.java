package info.chen.awsome_cws.dao;

import java.util.List;

import info.chen.awsome_cws.entity.Employee;

public interface EmployeeDao {
	
	Employee findEmployeeByEmpID(int id);
	
	List<Employee> getEmployees(int limitNum);

	void addEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployee(Employee employee);
}
