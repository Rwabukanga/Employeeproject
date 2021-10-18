package com.EmployeeManagementSystem.employeemanagementsystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.employeemanagementsystem.Domain.Systemuser;

@Service
public class AuthuserService implements UserDetailsService {

	@Autowired
	private SystemuserService userservice;
	
	@Autowired
	private EmployeeService employeeservice;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Systemuser systemuser = userservice.findByUsername(username);
		if(systemuser==null) 
			throw new UsernameNotFoundException("User 404");
		
			return systemuser;
	}
}

 