package info.chen.awsome.cws.persist.dao;

import java.util.List;
import java.util.Set;

import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.entity.Employee;

public interface DepartmentDao {

	Department getDepartmentById(String deptNo);

	List<Department> getAllDepartment();

	void addDepartment(Department department);

	void updateDepartment(Department department);

	void deleteDepartment(Department department);
	
	Set<Employee> getEmployeesByDepartmentID(String deptNo);
}
