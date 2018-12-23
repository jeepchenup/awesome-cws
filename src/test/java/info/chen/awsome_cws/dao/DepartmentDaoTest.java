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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class)
@WebAppConfiguration
public class DepartmentDaoTest {

	@Autowired
	DepartmentDao departmentDao;
	
	@Test
	public void testDepartmentDaoNotNull() {
		assertNotNull(departmentDao);
	}
	
	@Test
	public void testGetDepartmentById() {
		Department department = departmentDao.getDepartmentById("d001");
		System.out.println(department);
	}
	
	@Test
	public void testGetAllDepartment() {
		List<Department> departments = departmentDao.getAllDepartment();
		System.out.println(departments.size());
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
		System.out.println(department);
		department.setName("IT(modified)");
		departmentDao.updateDepartment(department);
		System.out.println("modified : " + department);
	}
	
	@Test
	public void testDeleteDepartment() {
		Department department = departmentDao.getDepartmentById("d010");
		if(department != null) {
			departmentDao.deleteDepartment(department);
			System.out.println(department);
		}
	}

}
