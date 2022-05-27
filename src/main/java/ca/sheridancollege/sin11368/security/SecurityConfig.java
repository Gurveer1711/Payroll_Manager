package ca.sheridancollege.sin11368.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ca.sheridancollege.sin11368.UserDetailsServiceImpl;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private LoginAccessDeniedHandler accessDeniedHanlder;
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		http.authorizeRequests().antMatchers("/viewEmployees").hasAnyRole("OWNER")
		.antMatchers("/").permitAll()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/addEmployee").hasAnyRole("OWNER")
		.antMatchers("/h2-console").permitAll()
		.antMatchers("/viewEmployee").hasAnyRole("EMPLOYEE")
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/?logout")
		.permitAll()
		.and()
		.exceptionHandling()
		.accessDeniedHandler(accessDeniedHanlder);
	}
	
	
}
