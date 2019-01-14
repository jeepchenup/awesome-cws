package info.chen.awsome.cws.service;

import java.util.List;
import java.util.Set;

import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.entity.Employee;

public interface DepartmentService {

	Department getDepartmentById(String deptNo);

	List<Department> getAllDepartment();

	void addDepartment(Department department);

	void updateDepartment(Department department);

	void deleteDepartmentByID(String deptNo);

	Set<Employee> getEmployeesByDepartmentID(String deptNo);

}
