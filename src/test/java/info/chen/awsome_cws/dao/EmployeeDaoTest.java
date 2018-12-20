package info.chen.awsome_cws.dao;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import info.chen.awsome_cws.configuration.HibernateConfiguration;
import info.chen.awsome_cws.entity.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class)
@org.springframework.test.context.web.WebAppConfiguration
public class EmployeeDaoTest {

	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Test
	public void testEmployeeDaoNotNull() {
		assertNotNull(employeeDao);
	}
	
	@Test
	public void testGetEmployeeByEmpId() {
		Employee employee = employeeDao.findEmployeeByEmpID(10001);
		System.out.println(employee);
	}
}
