package info.chen.awsome_cws.dao.impl;

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
		DepartmentEmployeeID departmentEmployeeID = new DepartmentEmployeeID();
		departmentEmployeeID.setEmpNo(empNo);
		return (List<Department>) getSession().get(DepartmentEmployee.class, departmentEmployeeID);
	}

	@Override
	public List<Employee> getEmployeesByDepartmentID(String deptNo) {
		Query query = getQuery("FROM DepartmentEmployee WHERE dept_no = :deptNo");
		query.setString("deptNo", deptNo);
		return query.list();
	}

}
