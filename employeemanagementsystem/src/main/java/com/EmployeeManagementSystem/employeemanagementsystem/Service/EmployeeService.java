package com.EmployeeManagementSystem.employeemanagementsystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.employeemanagementsystem.Domain.Employee;
import com.EmployeeManagementSystem.employeemanagementsystem.Domain.Position;

@Service
public interface EmployeeService {

	public Employee createEmployee(Employee registrar);
	public void updateRegistrar(Employee registrar);
	public void deleteEmployee(int id);
	public Optional<Employee> findByid(int id);
	public Optional<Employee> findByUuid(String uuid);
	public List<Employee> findAll(Class c);
	public Optional<Employee> findByName(String name);
	public Optional<Employee> findByEmail(String email);
	public Optional<Employee> findByPhonenumber(String phonenumber);
	public Optional<Employee> findByPosition(Position position);
}
