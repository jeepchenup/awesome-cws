package info.chen.awsome_cws_persist.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import info.chen.awsome_cws_persist.entity.Department;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:junitBeans.xml")
public class DepartmentDaoTest extends TestCase {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	protected void setUp() throws Exception {
	}

	@Override
	protected void tearDown() throws Exception {
	}

	@Test
	public void testDepartmentDaoNotNull() {
		assertNotNull(departmentDao);
	}
	
	@Test
	public void testGetDepartmentById() {
		Department department = departmentDao.getDepartmentById("d001");
	}
	
}
