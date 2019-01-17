package info.chen.awsome.cws.service;

import java.util.List;
import java.util.Set;

import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.entity.Employee;
import info.chen.awsome.cws.persist.exception.EmployeeException;

public interface EmployeeService {

	Employee getEmployeeByEmpID(Integer id) throws EmployeeException;

	List<Employee> getAllEmployees(Integer limitNum) throws EmployeeException;

	void addEmployee(Employee employee) throws EmployeeException;

	void updateEmployee(Employee employee) throws EmployeeException;

	void deleteEmployee(Employee employee) throws EmployeeException;

	Set<Department> getDepartmentsByEmployeeID(Integer id) throws EmployeeException;
}
