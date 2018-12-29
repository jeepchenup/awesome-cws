package info.chen.awsome_cws.dao;

import java.util.List;
import java.util.Set;

import info.chen.awsome_cws.entity.Department;
import info.chen.awsome_cws.entity.Employee;

public interface EmployeeDao {
	
	Employee findEmployeeByEmpID(Integer id);
	
	List<Employee> getEmployees(Integer limitNum);

	void addEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployee(Employee employee);
	
	Set<Department> getDepartmentsByEmployeeID(Integer id);
}
