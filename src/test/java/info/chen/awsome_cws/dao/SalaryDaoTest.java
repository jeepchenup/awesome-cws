package info.chen.awsome_cws.dao;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import info.chen.awsome_cws.configuration.HibernateConfiguration;
import info.chen.awsome_cws.entity.Employee;
import info.chen.awsome_cws.entity.Salary;
import info.chen.awsome_cws.entity.composite_id.SalaryID;
import info.chen.awsome_cws.util.CommonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class)
@WebAppConfiguration
public class SalaryDaoTest {

	@Autowired
	private SalaryDao salaryDao;
	
	@Test
	public void testSalaryDaoNotNull() {
		assertNotNull(salaryDao);
	}
	
	@Test
	public void testGetSalariesByEmployeeID() {
		List<Salary> salaries = salaryDao.getSalariesByEmployeeID(10001);
		System.out.println(salaries.size());
		for(Salary salary : salaries) {
			System.out.println(salary);
		}
		
	}
}
