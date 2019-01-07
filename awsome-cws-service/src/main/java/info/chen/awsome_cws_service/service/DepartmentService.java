package info.chen.awsome_cws_service.service;

import java.util.List;
import java.util.Set;

import info.chen.awsome_cws_persist.entity.Department;
import info.chen.awsome_cws_persist.entity.Employee;

public interface DepartmentService {

	Department getDepartmentById(String deptNo);

	List<Department> getAllDepartment();

	void addDepartment(Department department);

	void updateDepartment(Department department);

	void deleteDepartment(Department department);

	Set<Employee> getEmployeesByDepartmentID(String deptNo);

}
