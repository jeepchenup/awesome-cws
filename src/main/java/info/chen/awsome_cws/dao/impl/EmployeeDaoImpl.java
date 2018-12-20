package info.chen.awsome_cws.dao.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.chen.awsome_cws.dao.EmployeeDao;
import info.chen.awsome_cws.entity.Employee;

@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Employee findEmployeeByEmpID(int id) {
		Employee employee = (Employee) getSession().get(Employee.class, id);
		return employee;
	}

	@Override
	public Set<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
