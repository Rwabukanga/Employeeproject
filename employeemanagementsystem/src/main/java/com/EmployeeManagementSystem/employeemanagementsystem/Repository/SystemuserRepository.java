package com.EmployeeManagementSystem.employeemanagementsystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeManagementSystem.employeemanagementsystem.Domain.Systemuser;

@Repository
public interface SystemuserRepository extends JpaRepository<Systemuser, Long>{

	Optional<Systemuser> findById(long id);
	Optional<Systemuser> findByUuid(String uuid);
	public Systemuser findByUsernameAndPassword(String Username, String Password);
	public Systemuser findByUsername(String username); 
}
