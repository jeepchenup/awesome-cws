package info.chen.awsome_cws.dao;

import java.util.List;

import info.chen.awsome_cws.entity.Department;
import info.chen.awsome_cws.entity.Employee;

public interface DepartmentEmployeeDao {

	List<Department> getDepartmentsByEmployeeID(Integer empNo);
	
	List<Employee> getEmployeesByDepartmentID(String deptNo);
}
