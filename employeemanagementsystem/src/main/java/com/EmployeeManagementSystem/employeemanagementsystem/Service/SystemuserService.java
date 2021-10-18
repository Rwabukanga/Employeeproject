package com.EmployeeManagementSystem.employeemanagementsystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.employeemanagementsystem.Domain.Systemuser;


@Service
public interface SystemuserService {

	public String create(Systemuser user);
	public String update (Systemuser systemUser);
	public String delete(Systemuser systemUser);
	public Systemuser findByUsernameAndPassword(String Username, String Password);
	public Optional<Systemuser> findByuuid(String uuid); 
	public List<Systemuser>all();
	public Optional<Systemuser> findById(long id);
	public Systemuser findByUsername(String username); 
}
