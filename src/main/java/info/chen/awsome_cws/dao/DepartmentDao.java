package info.chen.awsome_cws.dao;

import java.util.List;

import info.chen.awsome_cws.entity.Department;

public interface DepartmentDao {

	Department getDepartmentById(String id);

	List<Department> getAllDepartment();

	void addDepartment(Department department);

	void updateDepartment(Department department);

	void deleteDepartment(Department department);
}
