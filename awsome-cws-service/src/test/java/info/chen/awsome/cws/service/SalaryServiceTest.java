package info.chen.awsome.cws.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import info.chen.awsome.cws.persist.entity.Salary;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:junitBeans.xml"})
public class SalaryServiceTest {
	
	@Autowired
	private SalaryService salaryService;
	
	@Test
	public void testSalaryServiceNotNull() {
		assertNotNull(salaryService);
	}
	
	@Test
	public void testGetSalariesByEmployeeID() {
		List<Salary> salaries = salaryService.getSalariesByEmployeeID(10001);
		assertEquals(17, salaries.size());
	}

}
