package info.chen.awsome.cws.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import info.chen.awsome.cws.web.aop.DataLayerAdvice;
import info.chen.awsome.cws.web.aop.SystemArchitecture;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"info.chen.awsome.cws.web.aop"})
public class AOPConfiguration {

	@Bean
	public SystemArchitecture getSystemArchitecture() {
		return new SystemArchitecture();
	}
	
	@Bean
	public DataLayerAdvice getDataLayerAdvice() {
		return new DataLayerAdvice();
	}
}
