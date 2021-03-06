package info.chen.awsome.cws.persist.dao.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import info.chen.awsome.cws.persist.dao.AbstractDao;
import info.chen.awsome.cws.persist.dao.EmployeeDao;
import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.entity.DepartmentEmployee;
import info.chen.awsome.cws.persist.entity.Employee;
import info.chen.awsome.cws.persist.exception.EmployeeException;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee> implements EmployeeDao{
	
	private static final Logger logger = LogManager.getLogger(EmployeeDaoImpl.class);
	
	@Override
	public Employee getEmployeeByEmpID(Integer id) throws EmployeeException {
		if(id == null) {
			logger.error("Employee ID Must Not Be Null.");
			throw new EmployeeException("Employee ID Must Not Be Null.");
		}
		
		logger.info("DAO -> Query employee {}", id);
		Employee employee = (Employee) getSession().get(Employee.class, id);
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees(Integer limitNum) throws EmployeeException{
		
		if(limitNum < 0)
			throw new EmployeeException("LimitNum Must Great than Zero.");
		
		List<Employee> employees = null;
		Criteria critria = getCriteria();
		if(limitNum == null || limitNum == 0) {
			critria.setMaxResults(limitNum);
		}
		employees = critria.list();
		
		logger.info("DAO -> Get All Employees, total size is {}", employees.size());
		return employees;
	}

	@Override
	public void addEmployee(Employee employee) throws EmployeeException{
		
		if(employee == null) {
			logger.error("Employee Not Be Null.");
			throw new EmployeeException("Employee Not Be Null Or EmpID Not Be Null.");
		}
		
		logger.info("DAO -> Add Employee: {}", employee);
		persistEntity(employee);
	}

	@Override
	public void updateEmployee(Employee employee) throws EmployeeException{
		
		if(employee == null || employee.getId() == null) {
			logger.error("Employee Not Be Null Or EmpID Not Be Null.");
			throw new EmployeeException("Employee Not Be Null Or EmpID Not Be Null.");
		}
		
		logger.info("DAO -> Update Employee : {}", employee);
		updateEntity(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) throws EmployeeException{
		
		if(employee == null || employee.getId() == null) {
			logger.error("Employee Not Be Null Or EmpID Not Be Null.");
			throw new EmployeeException("Employee Not Be Null Or EmpID Not Be Null.");
		}
		
		logger.info("DAO -> Delete Employee : {}", employee);
		deleteEntity(employee);
	}

	@Override
	public Set<Department> getDepartmentsByEmployeeID(Integer id) throws EmployeeException{
		
		if(id == null) {
			logger.error("EmpID Not Be Null.");
			throw new EmployeeException("Employee Not Be Null Or EmpID Not Be Null.");
		}
		
		Employee employee = getEmployeeByEmpID(id);
		Set<DepartmentEmployee> deSet = employee.getDepartmentEmployees();
		Set<Department> departments = new HashSet<Department>();
		Iterator<DepartmentEmployee> iterator = deSet.iterator();
		while(iterator.hasNext()) {
			departments.add(iterator.next().getDepartment());
		}
		logger.info("DAO -> {} employee works for [{}]", id, departments);
		return departments;
	}
	
}
