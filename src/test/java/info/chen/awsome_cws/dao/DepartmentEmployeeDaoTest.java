package info.chen.awsome_cws.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import info.chen.awsome_cws.configuration.HibernateConfiguration;
import info.chen.awsome_cws.entity.Department;
import info.chen.awsome_cws.entity.DepartmentEmployee;
import info.chen.awsome_cws.entity.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfiguration.class})
@WebAppConfiguration
public class DepartmentEmployeeDaoTest {

	@Autowired
	private DepartmentEmployeeDao departmentEmployeeDao;
	
	@Test
	public void testDepartmentEmployeeDaoNotNull() {
		assertNotNull(departmentEmployeeDao);
	}
	
	@Test
	public void testGetDepartmentsByEmployeeID() {
		List<Department> departments = departmentEmployeeDao.getDepartmentsByEmployeeID(10010);
		System.out.println(departments.size());
		for(Department department : departments) {
			System.out.println(department);
		}
	}
	
	@Test
	public void testGetEmployeesByDepartmentID() {
		List<Employee> employees = departmentEmployeeDao.getEmployeesByDepartmentID("d001");
		System.out.println(employees.size());
	}
}
