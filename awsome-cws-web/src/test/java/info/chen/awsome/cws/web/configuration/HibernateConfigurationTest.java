package info.chen.awsome.cws.web.configuration;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import info.chen.awsome.cws.web.configuration.HibernateConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class)
@WebAppConfiguration
public class HibernateConfigurationTest {

	@Autowired
	private HibernateConfiguration hibernateConfig;
	@Autowired
	HibernateTransactionManager hibernateTransactionManager;
	@Autowired
	DataSource dataSource;
	
	@Test
	public void testHibernateConfigurationNotNull() {
		assertNotNull(hibernateConfig);
		assertNotNull(hibernateTransactionManager);
		assertNotNull(dataSource);
	}
	
	/*@Test
	public void testHibernateConfig() {
		assertEquals("", hibernateConfig);
	}*/
}
