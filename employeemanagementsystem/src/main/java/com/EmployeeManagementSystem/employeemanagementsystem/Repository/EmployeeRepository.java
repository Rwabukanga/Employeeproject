package com.EmployeeManagementSystem.employeemanagementsystem.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeManagementSystem.employeemanagementsystem.Domain.Employee;
import com.EmployeeManagementSystem.employeemanagementsystem.Domain.Position;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	Optional<Employee> findById(int id);
	Optional<Employee> findByUuid(String uuid);
	Optional<Employee> findByEmail(String email);
	Optional<Employee> findByName(String name);
	Optional<Employee> findByPhonenumber(String emailAddress);
	Optional<Employee> findByPosition(Position position);
}
