package info.chen.awsome.cws.web.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// load other beans just like datasource, sessionFactory
		return new Class[] { HibernateConfiguration.class, AOPConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// load web component beans
		return new Class[] { WebAppConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/", "/cws"};
	}

}
