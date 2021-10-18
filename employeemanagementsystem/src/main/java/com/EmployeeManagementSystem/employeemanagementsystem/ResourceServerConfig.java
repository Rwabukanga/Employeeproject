package com.EmployeeManagementSystem.employeemanagementsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableResourceServer
@RestController
@Order(20)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	
	
	    @Override
	       public void configure(HttpSecurity http) throws Exception {
	        http.cors();
	        http.csrf().disable().authorizeRequests().antMatchers("/oauth/**", "/auth/**", "/employ/**", "/syst/**").permitAll()
	        .and() 
			.httpBasic() 
			.and() 
			.authorizeRequests()	 
	        .anyRequest()
	        .authenticated();
	    }
}
