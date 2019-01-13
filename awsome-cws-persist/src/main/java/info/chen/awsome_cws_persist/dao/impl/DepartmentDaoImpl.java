package info.chen.awsome_cws_persist.dao.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import info.chen.awsome_cws_persist.dao.AbstractDao;
import info.chen.awsome_cws_persist.dao.DepartmentDao;
import info.chen.awsome_cws_persist.entity.Department;
import info.chen.awsome_cws_persist.entity.DepartmentEmployee;
import info.chen.awsome_cws_persist.entity.Employee;

@Repository("departmentDao")
public class DepartmentDaoImpl extends AbstractDao<Department> implements DepartmentDao {

	private static Logger LOGGER = LoggerFactory.getLogger(DepartmentDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAllDepartment() {
		LOGGER.info("DAO -> Get all departments");
		Criteria ctiteria = getCriteria();
		ctiteria.addOrder(Order.asc("id"));
		return ctiteria.list();
	}

	@Override
	public void addDepartment(Department department) {
		LOGGER.info("DAO -> Add new department : {}", department);
		persistEntity(department);
	}

	@Override
	public void updateDepartment(Department department) {
		LOGGER.info("DAO -> Update department : {}", department);
		updateEntity(department);
	}

	@Override
	public void deleteDepartment(Department department) {
		LOGGER.info("DAO -> Delete department : {}", department);
		deleteEntity(department);
	}

	@Override
	public Department getDepartmentById(String id) {
		LOGGER.info("DAO -> Query department By {}", id);
		return (Department) getSession().get(Department.class, id);
	}

	@Override
	public Set<Employee> getEmployeesByDepartmentID(String deptNo) {
		
		Set<Employee> employees = new HashSet<Employee>();
		
		Department department = getDepartmentById(deptNo);
		Set<DepartmentEmployee> deptEmpSet = department.getDeptEmpSet();
		Iterator<DepartmentEmployee> iterator = deptEmpSet.iterator();
		while(iterator.hasNext()) {
			employees.add(iterator.next().getEmployee());
		}
		LOGGER.info("DAO -> Query Department id : {} - has {} emoloyees", deptNo, employees.size());
		return employees;
	}

}
