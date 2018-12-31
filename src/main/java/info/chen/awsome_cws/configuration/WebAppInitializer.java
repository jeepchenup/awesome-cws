package info.chen.awsome_cws.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 创建 DispatcherServlet 和 ContextLoaderListener
 * @author ABei
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {// 配置 ContextLoaderListener
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {// 配置 DispatcherServlet
		return new Class<?>[] { WebAppConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		// 将 DispatcherServlet 映射到 "/"，即会处理进入应用的所有请求
		return new String[] {"/"};
	}

}
