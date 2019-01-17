package info.chen.awsome.cws.persist.dao.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import info.chen.awsome.cws.persist.dao.AbstractDao;
import info.chen.awsome.cws.persist.dao.EmployeeDao;
import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.entity.DepartmentEmployee;
import info.chen.awsome.cws.persist.entity.Employee;
import info.chen.awsome.cws.persist.exception.EmployeeException;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Employee> implements EmployeeDao{
	
	private static Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoImpl.class);
	
	@Override
	public Employee getEmployeeByEmpID(Integer id) throws EmployeeException{
		LOGGER.info("DAO -> Query employee {}", id);
		Employee employee = (Employee) getSession().get(Employee.class, id);
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees(Integer limitNum) throws EmployeeException{
		
		List<Employee> employees = null;
		Criteria critria = getCriteria();
		if(limitNum != 0) {
			critria.setMaxResults(limitNum);
		}
		employees = critria.list();
		
		LOGGER.info("DAO -> Get All Employees, total size is {}", employees.size());
		return employees;
	}

	@Override
	public void addEmployee(Employee employee) throws EmployeeException{
		LOGGER.info("DAO -> Add Employee: {}", employee);
		persistEntity(employee);
	}

	@Override
	public void updateEmployee(Employee employee) throws EmployeeException{
		LOGGER.info("DAO -> Update Employee : {}", employee);
		updateEntity(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) throws EmployeeException{
		LOGGER.info("DAO -> Delete Employee : {}", employee);
		deleteEntity(employee);
	}

	@Override
	public Set<Department> getDepartmentsByEmployeeID(Integer id) throws EmployeeException{
		Employee employee = getEmployeeByEmpID(id);
		Set<DepartmentEmployee> deSet = employee.getDepartmentEmployees();
		Set<Department> departments = new HashSet<Department>();
		Iterator<DepartmentEmployee> iterator = deSet.iterator();
		while(iterator.hasNext()) {
			departments.add(iterator.next().getDepartment());
		}
		LOGGER.info("DAO -> {} employee works for [{}]", id, departments);
		return departments;
	}
	
}
