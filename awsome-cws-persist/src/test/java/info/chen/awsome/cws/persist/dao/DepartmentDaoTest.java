package info.chen.awsome.cws.persist.dao;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.entity.Employee;
import info.chen.awsome.cws.persist.exception.DepartmentException;
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
	public void testGetDepartmentById() throws DepartmentException {
		Department department = departmentDao.getDepartmentById("d001");

		assertEquals("d001", department.getId());
		assertEquals("Marketing", department.getName());
	}

	@Test
	public void testGetAllDepartment() throws DepartmentException {
		List<Department> departments = departmentDao.getAllDepartment();
		assertEquals(9, departments.size());
	}

	@Test
	@Rollback(false)// test finished and do not rollback data
	public void testAddDepartment() throws DepartmentException {
		Department department = new Department();
		department.setId("d010");
		department.setName("IT");
		departmentDao.addDepartment(department);
		
		department = departmentDao.getDepartmentById("d010");
		assertEquals("d010", department.getId());
		assertEquals("IT", department.getName());
	}

	@Test
	@Rollback(false)
	public void testUpdateDepartment() throws DepartmentException {
		Department department = departmentDao.getDepartmentById("d010");
		assertEquals("IT", department.getName());
		
		department.setName("Information Technology");
		departmentDao.updateDepartment(department);
		
		department = departmentDao.getDepartmentById("d010");
		assertEquals("Information Technology", department.getName());
	}

	@Test
	@Rollback(false)
	public void testDeleteDepartment() throws DepartmentException {
		Department department = departmentDao.getDepartmentById("d010");
		assertNotNull(department);
		
		departmentDao.deleteDepartment(department);
		
		department = departmentDao.getDepartmentById("d010");
		assertNull(department);
	}

	@Test
	public void testGetEmployeesByDepartmentID() throws DepartmentException {
		String departmentID = "d001";
		Department department = departmentDao.getDepartmentById(departmentID);
		Set<Employee> employees = departmentDao.getEmployeesByDepartmentID(departmentID);
		System.out.println(department.getName() + " has " + employees.size() + " employees");
	}

}
