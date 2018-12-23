package info.chen.awsome_cws.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import info.chen.awsome_cws.configuration.HibernateConfiguration;

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
}
