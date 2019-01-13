package info.chen.awsome_cws_persist.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome_cws_persist.entity.Salary;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:junitBeans.xml"})
@Transactional
public class SalaryDaoTest extends TestCase{

	@Autowired
	private SalaryDao salaryDao;
	
	@Test
	public void testSalaryDaoNotNull() {
		assertNotNull(salaryDao);
	}
	
	@Test
	public void testGetSalariesByEmployeeID() {
		List<Salary> salaries = salaryDao.getSalariesByEmployeeID(10001);
		for(Salary salary : salaries) {
			System.out.println(salary);
		}
	}
}
