package demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("csseifms").password("123456").roles("EMPLOYEE"))
		.withUser(users.username("rashmelonjr").password("1234567").roles("EMPLOYEE"))
		.withUser(users.username("basset").password("123").roles("MANAGER"))
		.withUser(users.username("maged").password("1").roles("ADMIN"));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").hasAnyRole("MANAGER", "EMPLOYEE", "ADMIN").antMatchers("/leaders")
				.hasAnyRole("MANAGER").antMatchers("/system").hasAnyRole("ADMIN").and().formLogin()
				.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll().and().logout()
				.permitAll().and().exceptionHandling().accessDeniedPage("/accessDeniedPage");
	}

}
