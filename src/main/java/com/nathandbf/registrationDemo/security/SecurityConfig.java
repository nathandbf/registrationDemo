package com.nathandbf.registrationDemo.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
	 * Method responsible for configuring authentication (allow access to isAlive and restrict access to others)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//isAlive doesn't need token...
		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/isAlive").permitAll() 
				.anyRequest().authenticated().and().oauth2ResourceServer().jwt();
	}
}
