package info.chen.awsome.cws.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import info.chen.awsome.cws.persist.entity.Department;
import info.chen.awsome.cws.persist.exception.DepartmentException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:junitBeans.xml")
public class DepartmentServiceTest {

	@Autowired
	private DepartmentService deptService;
	
	@Test
	public void testDepartmentServiceNotNull() {
		assertNotNull(deptService);
	}
	
	@Test
	public void testGetDepartmentById() throws DepartmentException {
		Department department = deptService.getDepartmentById("d001");
		
		assertEquals("d001", department.getId());
		assertEquals("Marketing", department.getName());
	}
	
	@Test
	public void testGetAllDepartment() throws DepartmentException {
		List<Department> departments = deptService.getAllDepartment();
		assertEquals(9, departments.size());
	}
	
	@Test
	public void testAddDepartment() throws DepartmentException {
		Department department = new Department();
		department.setId("d010");
		department.setName("IT");
		deptService.addDepartment(department);
		
		department = deptService.getDepartmentById("d010");
		assertEquals("d010", department.getId());
		assertEquals("IT", department.getName());
	}
	
	@Test
	public void testUpdateDepartment() throws DepartmentException {
		Department department = deptService.getDepartmentById("d010");
		assertEquals("IT", department.getName());
		
		department.setName("Information Technology");
		deptService.updateDepartment(department);
		
		department = deptService.getDepartmentById("d010");
		assertEquals("Information Technology", department.getName());
	}
	
	@Test
	public void testDeleteDepartment() throws DepartmentException {
		Department department = deptService.getDepartmentById("d010");
		assertNotNull(department);
		
		deptService.deleteDepartmentByID("d010");
		
		department = deptService.getDepartmentById("d010");
		assertNull(department);
	}
}
