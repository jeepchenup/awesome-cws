package info.chen.awsome_cws.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("info.chen.awsome_cws")
public class WebAppConfiguration extends WebMvcConfigurerAdapter {

	/**
	  * 配置视图解析器
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// 在 pom.xml 文件中需要添加 javax.servlet-api
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setViewClass(JstlView.class);
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		registry.viewResolver(internalResourceViewResolver);
	}

	/**
	  * 配置资源处理器，用于加载管理静态文件比如，css、js文件等
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
}
