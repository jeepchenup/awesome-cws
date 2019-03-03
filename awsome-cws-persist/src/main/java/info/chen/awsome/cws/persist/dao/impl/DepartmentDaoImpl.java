package info.chen.awsome.cws.persist.dao.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import info.chen.awsome.cws.persist.dao.AbstractDao;
import info.chen.awsome.cws.persist.dao.DepartmentDao;
import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.entity.DepartmentEmployee;
import info.chen.awsome.cws.persist.entity.Employee;
import info.chen.awsome.cws.persist.exception.DepartmentException;

@Repository("departmentDao")
public class DepartmentDaoImpl extends AbstractDao<Department> implements DepartmentDao {

	private static final Logger logger = LogManager.getLogger(DepartmentDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAllDepartment() {
		logger.info("DAO -> Get all departments");
		Criteria ctiteria = getCriteria();
		ctiteria.addOrder(Order.asc("id"));
		return ctiteria.list();
	}

	@Override
	public void addDepartment(Department department) throws DepartmentException {
		
		if(department == null || department.getId().equals("")) {
			logger.error("Department Must Not Null.");
			throw new DepartmentException("Department Must Not Null.");
		}

		logger.info("DAO -> Add new department : {}", department);
		persistEntity(department);
	}

	@Override
	public void updateDepartment(Department department) throws DepartmentException{
		
		if(department == null || department.getId().equals("")) {
			logger.error("Department Must Not Null.");
			throw new DepartmentException("Department Must Not Null.");
		}
		
		logger.info("DAO -> Update department : {}", department);
		updateEntity(department);
	}

	@Override
	public void deleteDepartment(Department department) throws DepartmentException{
		if(department == null || department.getId() == null) {
			logger.error("Department Or Department ID Must Not Null.");
			throw new DepartmentException("Department Or Department ID Must Not Null.");
		}

		logger.info("DAO -> Delete department : {}", department);
		deleteEntity(department);
	}

	@Override
	public Department getDepartmentById(String id) throws DepartmentException{
		
		if(id == null || id.equals("")) {
			logger.error("Department ID Must Not Null.");
			throw new DepartmentException("Department ID Must Not Null.");
		}
		
		logger.info("DAO -> Query department By {}", id);
		return (Department) getSession().get(Department.class, id);
	}

	@Override
	public Set<Employee> getEmployeesByDepartmentID(String deptNo) throws DepartmentException{
		
		if(deptNo == null || deptNo.equals("")) {
			logger.error("Department ID Must Not Null Or Null Empty.");
			throw new DepartmentException("Department ID Must Not Null.");
		}
		
		Department department = getDepartmentById(deptNo);
		
		Set<DepartmentEmployee> deptEmpSet = department.getDeptEmpSet();
		Set<Employee> employees = new HashSet<Employee>();
		Iterator<DepartmentEmployee> iterator = deptEmpSet.iterator();
		while(iterator.hasNext()) {
			employees.add(iterator.next().getEmployee());
		}
		logger.info("DAO -> Query Department id : {} - has {} emoloyees", deptNo, employees.size());
		return employees;
	}

}
