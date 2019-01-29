package info.chen.awsome.cws.web.configuration;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import info.chen.awsome.cws.security.configuration.CWSSecurityConfiguration;
import info.chen.awsome.cws.service.EmployeeService;
import info.chen.awsome.cws.web.configuration.WebAppConfiguration;
import info.chen.awsome.cws.web.controller.EmployeeController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebAppConfiguration.class)
@org.springframework.test.context.web.WebAppConfiguration
public class WebAppConfigurationTest {

	@Autowired
	private WebAppConfiguration webAppConfiguration;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeController employeeController;
	
	@Autowired
	private CWSSecurityConfiguration securityConfiguration;
	
	@Test
	public void testWebAppConfigurationNotNull() {
		assertNotNull(webAppConfiguration);
		assertNotNull(employeeService);
		assertNotNull(employeeController);
		assertNotNull(securityConfiguration);
	}
}
