package br.edu.ifpb.mt.sdr.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * 
 * <p>
 * <b> Security Configuration </b>
 * </p>
 *
 * <p>
 * 	Class define configurations of authorizations 
 * </p>
 * 
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * 
	 * Authentication in memory, only tests
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user").password("123").roles("USER")
			.and().withUser("admin").password("admin").roles("ADMIN");

	}

	/**
	 * Permitions by Methos and role
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
			.antMatchers(HttpMethod.POST, "/authors", "/books").hasRole("ADMIN")
			.antMatchers(HttpMethod.PATCH, "/authors", "/books").hasRole("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/authors", "/books").hasRole("ADMIN")
			.and().csrf().disable();
	}

}
