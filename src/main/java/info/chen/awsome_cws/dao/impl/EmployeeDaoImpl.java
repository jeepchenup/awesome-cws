package info.chen.awsome_cws.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import info.chen.awsome_cws.dao.AbstractDao;
import info.chen.awsome_cws.dao.EmployeeDao;
import info.chen.awsome_cws.entity.Employee;

@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl extends AbstractDao<Employee> implements EmployeeDao{

	@Override
	public Employee findEmployeeByEmpID(int id) {
		Employee employee = (Employee) getSession().get(Employee.class, id);
		return employee;
	}

	@Override
	public List<Employee> getEmployees(int limitNum) {
		Criteria critria = getCriteria();
		if(limitNum != 0) {
			critria.setMaxResults(limitNum);
		}
		return critria.list();
	}

	@Override
	public void addEmployee(Employee employee) {
		persistEntity(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		updateEntity(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		deleteEntity(employee);
	}
	
}
