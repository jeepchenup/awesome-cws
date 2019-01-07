package info.chen.awsome_cws_service.service;

import java.util.List;
import java.util.Set;

import info.chen.awsome_cws_persist.entity.Department;
import info.chen.awsome_cws_persist.entity.Employee;

public interface EmployeeService {

	Employee getEmployeeByEmpID(Integer id);

	List<Employee> getAllEmployees(Integer limitNum);

	void addEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(Employee employee);

	Set<Department> getDepartmentsByEmployeeID(Integer id);
}
