package info.chen.awsome.cws.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Set;

import org.awsome.cws.common.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.entity.Employee;
import info.chen.awsome.cws.persist.entity.Gender;
import info.chen.awsome.cws.persist.exception.EmployeeException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:junitBeans.xml")
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void testEmployeeServiceNotNull() {
		assertNotNull(employeeService);
	}
	
	@Test
	public void testGetEmployeeByEmpID() throws EmployeeException {
		Employee employee = employeeService.getEmployeeByEmpID(10001);
		
		assertNotNull(employee);
		assertEquals("Georgi", employee.getFirstName());
		assertEquals("Facello", employee.getLastName());
		assertEquals(Gender.M, employee.getGender());
		assertEquals(DateUtils.getDate("1953-09-02"), employee.getBirthDate());
		assertEquals(DateUtils.getDate("1986-06-26"), employee.getHireDate());
	}
	
	@Test
	public void testGetAllEmployees() throws EmployeeException {
		List<Employee> employees = employeeService.getAllEmployees(0);
		assertEquals(300024, employees.size());
	}
	
	@Test
	public void testAddEmployee() throws EmployeeException {
		Employee employee = new Employee();
		employee.setFirstName("Bob");
		employee.setLastName("Smith");
		employee.setGender(Gender.M);
		employee.setBirthDate("1989-10-10");
		employee.setHireDate("2019-1-1");
		
		employeeService.addEmployee(employee);
		
		Employee addedEmployee = employeeService.getEmployeeByEmpID(employee.getId());
		
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
		Employee employee = employeeService.getEmployeeByEmpID(500001);
		
		assertNotNull(employee);
		assertEquals(Gender.M, employee.getGender());
		
		employee.setGender(Gender.F);
		employeeService.updateEmployee(employee);
		
		Employee updatedEmployee = employeeService.getEmployeeByEmpID(500001);
		assertEquals(Gender.F, updatedEmployee.getGender());
	}
	
	@Test 
	public void testDeleteEmployee() throws EmployeeException {
		Employee employee = employeeService.getEmployeeByEmpID(500001);
		assertNotNull(employee);
		
		employeeService.deleteEmployee(employee);
		
		Employee deletedEmployee = employeeService.getEmployeeByEmpID(500001);
		assertNull(deletedEmployee);
	}
	
	@Test
	public void testGetDepartmentsByEmployeeID() throws EmployeeException {
		Set<Department> departments = employeeService.getDepartmentsByEmployeeID(10010);
		assertNotNull(departments);
		assertEquals(2, departments.size());
	}
}
