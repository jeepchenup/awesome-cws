package info.chen.awsome.cws.persist.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Set;

import org.awsome.cws.common.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.entity.Employee;
import info.chen.awsome.cws.persist.entity.Gender;
import info.chen.awsome.cws.persist.exception.EmployeeException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:junitBeans.xml" })
@Transactional
public class EmployeeDaoTest {

	@Autowired
	private EmployeeDao employeeDao;

	@Test
	public void testEmployeeDaoNotNull() {
		assertNotNull(employeeDao);
	}

	@Test
	public void testGetEmployeeByEmpID() throws EmployeeException {
		Employee employee = employeeDao.getEmployeeByEmpID(10001);

		assertNotNull(employee);
		assertEquals("Georgi", employee.getFirstName());
		assertEquals("Facello", employee.getLastName());
		assertEquals(Gender.M, employee.getGender());
		assertEquals(DateUtils.getDate("1953-09-02"), employee.getBirthDate());
		assertEquals(DateUtils.getDate("1986-06-26"), employee.getHireDate());
	}

	@Test
	public void testGetAllEmployee() throws EmployeeException {
		List<Employee> employees = employeeDao.getAllEmployees(0);
		assertEquals(300024, employees.size());
	}

	@Test
	public void testGetDepartmentsByEmployeeID() throws EmployeeException {
		Set<Department> departments = employeeDao.getDepartmentsByEmployeeID(10010);
		assertNotNull(departments);
		assertEquals(2, departments.size());
	}

	@Test
	public void testAddEmployee() throws EmployeeException {
		Employee employee = new Employee();
		employee.setFirstName("Bob");
		employee.setLastName("Smith");
		employee.setGender(Gender.M);
		employee.setBirthDate("1989-10-10");
		employee.setHireDate("2019-1-1");

		employeeDao.addEmployee(employee);

		Employee addedEmployee = employeeDao.getEmployeeByEmpID(employee.getId());

		assertNotNull(employee);
		assertEquals(employee.getId(), addedEmployee.getId());
		assertEquals(employee.getFirstName(), addedEmployee.getFirstName());
		assertEquals(employee.getLastName(), addedEmployee.getLastName());
		assertEquals(employee.getGender(), addedEmployee.getGender());
		assertEquals(employee.getBirthDate(), addedEmployee.getBirthDate());
		assertEquals(employee.getHireDate(), addedEmployee.getHireDate());
	}

	@Test
	public void testUpdateEmployee() throws EmployeeException {
		Employee employee = employeeDao.getEmployeeByEmpID(500001);

		assertNotNull(employee);
		assertEquals(Gender.M, employee.getGender());

		employee.setGender(Gender.F);
		employeeDao.updateEmployee(employee);

		Employee updatedEmployee = employeeDao.getEmployeeByEmpID(500001);
		assertEquals(Gender.F, updatedEmployee.getGender());
	}

	@Test
	public void testDeleteEmployee() throws EmployeeException {
		Employee employee = employeeDao.getEmployeeByEmpID(500001);
		assertNotNull(employee);
		
		employeeDao.deleteEmployee(employee);
		
		Employee deletedEmployee = employeeDao.getEmployeeByEmpID(500001);
		assertNull(deletedEmployee);
	}

}
