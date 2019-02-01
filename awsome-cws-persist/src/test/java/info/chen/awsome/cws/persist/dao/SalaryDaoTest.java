package info.chen.awsome.cws.persist.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.awsome.cws.common.util.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome.cws.persist.entity.Salary;
import info.chen.awsome.cws.persist.entity.composite_id.SalaryID;
import info.chen.awsome.cws.persist.exception.SalaryException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:junitBeans.xml"})
@Transactional
public class SalaryDaoTest {

	@Autowired
	private SalaryDao salaryDao;
	
	@Test
	public void testSalaryDaoNotNull() {
		assertNotNull(salaryDao);
	}
	
	@Test
	public void testGetSalariesByEmployeeID() throws SalaryException {
		List<Salary> salaries = salaryDao.getSalariesByEmployeeID(10001);
		for(Salary salary : salaries) {
			System.out.println(salary);
		}
	}
	
	@Test
	public void testGetLatestSalary() throws SalaryException {
		Salary salary = salaryDao.getLatestSalary(10001);
		assertNotNull(salary);
		
		assertEquals(new Integer(10001), salary.getSalaryID().getEmpNo());
		assertEquals(new Integer(88958), salary.getSalary());
		assertEquals(DateUtils.getDate("2002-06-22"), salary.getSalaryID().getFromDate());
		assertEquals(DateUtils.getDate("9999-01-01"), salary.getToDate());
	}
	
	@Test
	@Rollback(false)
	public void testAddSalary() throws SalaryException {
		SalaryID salaryID = new SalaryID();
		salaryID.setEmpNo(500002);
		salaryID.setFromDate(DateUtils.getDate("2019-1-27"));
		
		Salary salary = new Salary();
		
		salary.setSalary(80000);
		salary.setToDate(DateUtils.getDate("2020-1-27"));
		salary.setSalaryID(salaryID);
		
		salaryDao.addSalary(salary);
	}
}
