package info.chen.awsome.cws.security.configuration;

import org.awsome.cws.common.constants.APISecurityConstatnts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 1. RESTFUL API close the CSRF function and be authenticated by basic HTTP.
 * 2. Others API open then CSRF function and be authenticated by LoginForm.
 */
@EnableWebSecurity
@Configuration
public class MultiHttpSecurityConfigration {
	
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
				.antMatcher(APISecurityConstatnts.RESTFUL_API)
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
				.formLogin()
					.loginPage("/login").permitAll();
		}

	}
}
