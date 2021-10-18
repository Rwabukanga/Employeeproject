package com.EmployeeManagementSystem.employeemanagementsystem.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.employeemanagementsystem.Domain.Employee;
import com.EmployeeManagementSystem.employeemanagementsystem.Domain.Position;
import com.EmployeeManagementSystem.employeemanagementsystem.Repository.EmployeeRepository;
import com.EmployeeManagementSystem.employeemanagementsystem.Service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository employeerepository;

	@Override
	public Employee createEmployee(Employee registrar) {
		// TODO Auto-generated method stub
		return employeerepository.save(registrar);
	}

	@Override
	public void updateRegistrar(Employee registrar) {
		// TODO Auto-generated method stub
		employeerepository.save(registrar);
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeerepository.deleteById(id);
	}

	@Override
	public Optional<Employee> findByid(int id) {
		// TODO Auto-generated method stub
		return employeerepository.findById(id);
	}

	@Override
	public Optional<Employee> findByUuid(String uuid) {
		// TODO Auto-generated method stub
		return employeerepository.findByUuid(uuid);
	}

	@Override
	public List<Employee> findAll(Class c) {
		// TODO Auto-generated method stub
		return employeerepository.findAll();
	}

	@Override
	public Optional<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		return employeerepository.findByName(name);
	}

	@Override
	public Optional<Employee> findByEmail(String email) {
		// TODO Auto-generated method stub
		return employeerepository.findByEmail(email);
	}

	@Override
	public Optional<Employee> findByPhonenumber(String phonenumber) {
		// TODO Auto-generated method stub
		return employeerepository.findByPhonenumber(phonenumber);
	}

	@Override
	public Optional<Employee> findByPosition(Position position) {
		// TODO Auto-generated method stub
		return employeerepository.findByPosition(position);
	}
	
	
	
}
