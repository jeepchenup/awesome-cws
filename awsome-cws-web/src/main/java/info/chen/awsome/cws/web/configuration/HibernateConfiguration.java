package info.chen.awsome.cws.web.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value= {"classpath:hibernate.properties"})
@ComponentScan(basePackages = "info.chen.awsome.cws.web.configuration")
public class HibernateConfiguration {

	@Autowired
	private Environment environment;
	
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean() {// 通过 Spring IoC 创建出 Hibernate Session Factory
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		// 设置数据源
		localSessionFactoryBean.setDataSource(getDataSource());
		// 指定持久类路径
		localSessionFactoryBean.setPackagesToScan(new String[] {"info.chen.awsome_cws_persist.entity"});
		// 指定 Hibernate 配置
		localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
		
		return localSessionFactoryBean;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {// 事务管理
		// 这里注入的 sessionFactory 对象是上面 getLocalSessionFactoryBean() 方法生成的
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.import_files", environment.getRequiredProperty("hibernate.hbm2ddl.import_files"));
        return properties;  
	}
}
