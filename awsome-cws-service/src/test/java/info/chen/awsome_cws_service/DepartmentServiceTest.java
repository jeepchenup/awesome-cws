package info.chen.awsome_cws_service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import info.chen.awsome_cws_service.service.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:junitBeans.xml")
public class DepartmentServiceTest {

	@Autowired
	private DepartmentService deptService;
	
	@Test
	public void testDepartmentServiceNotNull() {
		assertNotNull(deptService);
	}
}
