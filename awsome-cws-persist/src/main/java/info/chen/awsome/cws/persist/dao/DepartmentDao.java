package info.chen.awsome.cws.persist.dao;

import java.util.List;
import java.util.Set;

import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.entity.Employee;
import info.chen.awsome.cws.persist.exception.DepartmentException;

public interface DepartmentDao {

	Department getDepartmentById(String deptNo) throws DepartmentException;

	List<Department> getAllDepartment() throws DepartmentException;

	void addDepartment(Department department) throws DepartmentException;

	void updateDepartment(Department department) throws DepartmentException;

	void deleteDepartment(Department department) throws DepartmentException;
	
	Set<Employee> getEmployeesByDepartmentID(String deptNo) throws DepartmentException;
}
