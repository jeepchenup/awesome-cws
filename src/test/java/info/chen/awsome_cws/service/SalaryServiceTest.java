package info.chen.awsome_cws.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import info.chen.awsome_cws.configuration.HibernateConfiguration;
import info.chen.awsome_cws.configuration.WebAppConfiguration;
import info.chen.awsome_cws.entity.Salary;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {WebAppConfiguration.class, HibernateConfiguration.class})
@org.springframework.test.context.web.WebAppConfiguration
public class SalaryServiceTest {

	@Autowired
	SalaryService salaryService;
	
	@Test
	public void testSalaryServiceNotNull() {
		assertNotNull(salaryService);
	}
	
	@Test
	public void testGetSalariesByEmployeeID() {
		List<Salary> salaries = salaryService.getSalariesByEmployeeID(10001);
	}
}
