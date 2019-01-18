package info.chen.awsome.cws.web.configuration;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome.cws.persist.dao.EmployeeDao;
import info.chen.awsome.cws.persist.entity.Employee;
import info.chen.awsome.cws.persist.exception.EmployeeException;
import info.chen.awsome.cws.web.aop.EmployeeAdvice;
import info.chen.awsome.cws.web.aop.SystemArchitecture;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AOPConfiguration.class, WebAppConfiguration.class } )
@org.springframework.test.context.web.WebAppConfiguration
public class AOPConfigurationTest {
	
	@Autowired
	private SystemArchitecture systemArchitecture;
	@Test
	public void testSystemArchitectureNotNull() {
		assertNotNull(systemArchitecture);
	}
	
	@Autowired
	private EmployeeAdvice employeeAdvice;
	@Test
	public void testEmployeeAdviceNotNull() {
		assertNotNull(employeeAdvice);
	}
	
	@Autowired
	private EmployeeDao employeeDao;
	@Test
	@Transactional
	public void testEmployeeAdviceDoAccessCheck() throws EmployeeException {
		assertNotNull(employeeDao);
		Employee employee = employeeDao.getEmployeeByEmpID(10001);
	}
	
}
