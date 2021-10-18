package com.EmployeeManagementSystem.employeemanagementsystem.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.employeemanagementsystem.Domain.Systemuser;
import com.EmployeeManagementSystem.employeemanagementsystem.Repository.SystemuserRepository;
import com.EmployeeManagementSystem.employeemanagementsystem.Service.SystemuserService;
import com.EmployeeManagementSystem.employeemanagementsystem.Utility.Msg;

@Service
public class SystemuserImplementation implements SystemuserService {

	@Autowired
	private SystemuserRepository userrepo;
	
	@Override
	public String create(Systemuser user) {
		String message=""; 
		try{
			/* user.setPassword(Encryption.md5(user.getPassword())); */
			
			  final String hashedPassword = BCrypt.hashpw(user.getPassword(),
			  BCrypt.gensalt());
			 
			 user.setPassword(hashedPassword); 
			userrepo.save(user);
			message=Msg.save;
		}catch (Exception e) {
			message=Msg.error;
		}
		return message;
	}

	@Override
	public String update(Systemuser systemUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Systemuser systemUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Systemuser findByUsernameAndPassword(String Username, String Password) {
		// TODO Auto-generated method stub
		return userrepo.findByUsernameAndPassword(Username, Password);
	}

	@Override
	public Optional<Systemuser> findByuuid(String uuid) {
		// TODO Auto-generated method stub
		return userrepo.findByUuid(uuid);
	}

	@Override
	public List<Systemuser> all() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

	@Override
	public Optional<Systemuser> findById(long id) {
		// TODO Auto-generated method stub
		return userrepo.findById(id);
	}

	@Override
	public Systemuser findByUsername(String username) {
		// TODO Auto-generated method stub
		return userrepo.findByUsername(username);
	}

	
	
}
