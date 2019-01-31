package info.chen.awsome.cws.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
@Configuration
public class MultiHttpSecurityConfigration {
	
//	@Autowired
//	private static RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Autowired
	public void registerGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user").password("password").roles("USER")
			.and()
			.withUser("admin").password("password").roles("USER", "ADMIN");
	}

	@Configuration
	@Order(1)
	public static class RestfulAPIWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
	
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
//				.exceptionHandling()
//					.authenticationEntryPoint(restAuthenticationEntryPoint)
//				.and()
				.antMatcher("/rest/**")
				.authorizeRequests()
					.anyRequest().authenticated()
				.and()
				.httpBasic();
		}

	}

	@Configuration
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
					.anyRequest().authenticated()
				.and()
				.formLogin();
		}

	}
}
