package info.chen.awsome_cws.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome_cws.dao.AbstractDao;
import info.chen.awsome_cws.dao.DepartmentEmployeeDao;
import info.chen.awsome_cws.entity.Department;
import info.chen.awsome_cws.entity.DepartmentEmployee;
import info.chen.awsome_cws.entity.Employee;
import info.chen.awsome_cws.entity.composite_id.DepartmentEmployeeID;

@Repository("departmentEmployeeDao")
@Transactional
public class DepartmentEmployeeDaoImpl extends AbstractDao<DepartmentEmployee> implements DepartmentEmployeeDao {

	@Override
	public List<Department> getDepartmentsByEmployeeID(Integer empNo) {
		Query query = getQuery("FROM DepartmentEmployee WHERE emp_no=:empNo");
		query.setInteger("empNo", empNo);
		List<DepartmentEmployee> deptEmps = query.list();
		List<Department> departments = new ArrayList<Department>();
		for(DepartmentEmployee deptEmp : deptEmps) {
			departments.add(deptEmp.getDepartment());
		}
		return departments;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentID(String deptNo) {
		List<Employee> employees = new ArrayList<Employee>();
		
		Query query = getQuery("FROM DepartmentEmployee WHERE dept_no=:deptNo");
		query.setString("deptNo", deptNo);
		List<DepartmentEmployee> deptEmps = query.list();
		for(DepartmentEmployee deptEmp : deptEmps) {
			employees.add(deptEmp.getEmployee());
		}
		return employees;
	}

}
