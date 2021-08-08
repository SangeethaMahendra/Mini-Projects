package com.sangeetha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangeetha.entity.Employee;
import com.sangeetha.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	//add employee - Post
	public Employee addEmployee(Employee employee) {
		return repo.save(employee);
	}
	
	//add employees - Post
	public List<Employee> addEmployees(List<Employee> employees){
		return (List<Employee>) repo.saveAll(employees);
	}
	
	//get employee by id - Get
	public Optional<Employee> getEmployeeById(int id) { //Optional to avoid null values or use orElse(null)
		return repo.findById(id);	
	}
	
	//get employees -Get
	public List<Employee> getEmployees() {
		return (List<Employee>) repo.findAll();
	}
	
	//update employee  - Put
	public Employee updateEmployee(Employee id) {
		return repo.save(id);
	}
	
	//delete employee - Delete
	public String deleteEmployee(int id) { //if not return any value then give void
       repo.deleteById(id);
       return "Employee got removed";
}
}
