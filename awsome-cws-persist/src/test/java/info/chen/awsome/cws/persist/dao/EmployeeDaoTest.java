package info.chen.awsome.cws.persist.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:junitBeans.xml"})
@Transactional
public class EmployeeDaoTest {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Test
	public void testEmployeeDaoNotNull() {
		assertNotNull(employeeDao);
	}
	
	@Test
	public void testGetEmployeeByEmpID() {
		Employee employee = employeeDao.getEmployeeByEmpID(10001);

		assertNotNull(employee);
		assertEquals("Georgi", employee.getFirstName());
		assertEquals("Facello", employee.getLastName());
		assertEquals(Gender.M, employee.getGender());
		assertEquals(DateUtils.getDate("1953-09-02"), employee.getBirthDate());
		assertEquals(DateUtils.getDate("1986-06-26"), employee.getHireDate());
	}
	
	@Test
	public void testGetAllEmployee() {
		List<Employee> employees = employeeDao.getAllEmployees(0);
		System.out.println(employees.size());
	}
	
	@Test
	public void testGetDepartmentsByEmployeeID() {
		Set<Department> departments;
		departments = employeeDao.getDepartmentsByEmployeeID(10001);
		for(Department department : departments) {
			System.out.println(department);
		}
		
		departments = employeeDao.getDepartmentsByEmployeeID(10010);
		for(Department department : departments) {
			System.out.println(department);
		}
	}
	
	@Test
	public void testAddEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("Jorge");
		employee.setLastName("Smith");
		employee.setGender(Gender.M);
		employee.setBirthDate("1989-10-10");
		employeeDao.addEmployee(employee);
	}
	
	@Test
	public void testUpdateEmployee() {
		Employee employee = employeeDao.getEmployeeByEmpID(500000);
		employee.setHireDate("2000-2-2");
		employeeDao.updateEmployee(employee);
	}
	
	@Test
	public void testDeleteEmployee() {
		Employee employee = new Employee();
		employee.setId(500000);
		employeeDao.deleteEmployee(employee);
	}
	
}
