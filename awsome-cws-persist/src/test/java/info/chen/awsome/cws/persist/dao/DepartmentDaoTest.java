package info.chen.awsome.cws.persist.dao;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.entity.Employee;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:junitBeans.xml")
@Transactional
public class DepartmentDaoTest extends TestCase {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Test
	public void testDepartmentDaoNotNull() {
		assertNotNull(departmentDao);
	}
	
	@Test
	public void testGetDepartmentById() {
		Department department1 = departmentDao.getDepartmentById("d001");
		Department department2 = departmentDao.getDepartmentById("d001");
		System.out.println(department1.equals(department2));
	}
	
	@Test
	public void testGetAllDepartment() {
		List<Department> departments = departmentDao.getAllDepartment();
		for(Department department : departments) {
			System.out.println(department);
		}
	}
	
	@Test
	public void testAddDepartment() {
		Department department = new Department();
		department.setId("d010");
		department.setName("IT");
		departmentDao.addDepartment(department);
	}
	
	@Test
	public void testUpdateDepartment() {
		Department department = departmentDao.getDepartmentById("d010");
		department.setName("Information Technology");
		departmentDao.updateDepartment(department);
	}
	
	@Test
	public void testDeleteDepartment() {
		Department department = new Department();
		department.setId("d010");
		departmentDao.deleteDepartment(department);
	}
	
	@Test
	public void testGetEmployeesByDepartmentID() {
		String departmentID = "d001";
		Department department = departmentDao.getDepartmentById(departmentID);
		Set<Employee> employees = departmentDao.getEmployeesByDepartmentID(departmentID);
		System.out.println(department.getName() + " has " + employees.size() + " employees");
	}
	
}
