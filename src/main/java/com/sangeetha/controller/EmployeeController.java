package com.sangeetha.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sangeetha.customException.RecordNotFoundException;
import com.sangeetha.entity.Employee;
import com.sangeetha.service.EmployeeService;

@RestController
public class EmployeeController<Empolyee> {
	
	@Autowired
	private EmployeeService service;
	
	//add employee - PostMapping 
	@PostMapping(value = "/addEmployee")
	public Employee saveEmployee(@RequestBody Employee Emp) {
		return service.addEmployee(Emp);	
	}
	
	//add employees - PostMapping
	@PostMapping(value = "/addAllEmployee", consumes ="application/json" )
	public List<Employee> saveAllEmployee(@RequestBody List<Employee> AllEmployee){
		return service.addEmployees(AllEmployee);
	}
	
	//find employee by id - GetMapping
	public static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	@GetMapping (value = "/getEmployee/{id}" , produces ="application/json" )
	//public Optional<Employee> getEmployee(@PathVariable int id) {
	//return service.getEmployeeById(id);
	
	//ExceptionHandling
	//1.1st control comes to controller class and check record is exist or not
 	public ResponseEntity <Employee> getEmployeeById(@PathVariable Integer id) throws RecordNotFoundException {
		log.info("getEmployeeById() execution starts");
		Optional<Employee> op = service.getEmployeeById(id);
		if(op.isPresent())
		{
			// 2. if record exist this block will get executed
			log.info("getEmployeeById() execution ends");
			return new ResponseEntity<Employee>(op.get(),HttpStatus.OK);
		} // 3. if not execute else block 
		else {
			// 4.here we are creating custom exception method,passing a msg and throw this exception to JVM by using throw keyword
			// 5.now JVM verify whether the class name is exist or not and go to RecordNotFoundException class
			throw new RecordNotFoundException("Record does not Exist");
		}
		
	 //return null;
	}
	
	//find all employees - GetMapping
	@GetMapping(value = "/getEmployees")
	public List<Employee> getEmployees(){
		return service.getEmployees();
	}
	
	
	//update employee by id - PutMapping
	@PutMapping(value = "/updateEmployee")
	public Employee update(@RequestBody Employee id) {
		return service.updateEmployee(id);	
	}
	
	
	//delete employee by id - DeleteMapping
	@DeleteMapping(value = "/deleteEmployeeRecord/{id}")
	public String delete(@PathVariable int id) {
	    service.deleteEmployee(id);
	return "Employee record deleted successfully";
	

}
}
