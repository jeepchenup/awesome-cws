package info.chen.awsome_cws.congiguration;

import static org.junit.Assert.assertNotNull;

import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import info.chen.awsome_cws.configuration.HibernateConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class)
//配置类（被 @Configuration 修饰的类）需要添加 @WebAppConfiguration 注解
@org.springframework.test.context.web.WebAppConfiguration
public class HibernateConfigurationTest {

	@Autowired
	HibernateConfiguration hibernateConfiguration;
	
	@Autowired
	HibernateTransactionManager hibernateTransactionManager;
	
	@Autowired
	DataSource dataSource;
	
	@Test
	public void testInternalBeanIfInit() {
		assertNotNull(hibernateConfiguration);
		assertNotNull(dataSource);
		assertNotNull(hibernateTransactionManager);
	}
	
}
