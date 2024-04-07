package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees") ///employees
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<Employee> createUsers(@RequestBody Employee employees){
		Employee savedemployee = employeesService.createUsers(employees);
		return new ResponseEntity<>(savedemployee, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getUserById(@PathVariable("id") Long id){
		Employee user = usersService.getUsersById(id);
	    return new ResponseEntity<>(user, HttpStatus.OK);
	}
	 
		
	@GetMapping 
	public ResponseEntity<List<Users>> getAllUsers(){ 
		List<Users> users = usersService.getAllUsers(); 
		return new ResponseEntity<>(users,HttpStatus.OK); 
	}
	    
	@PutMapping("{id}")
	// http://localhost:8080/api/users/1
	public ResponseEntity<Users> updateUser(@PathVariable("id") Long id,@RequestBody Users users){
		users.setId(id);
	    Users updatedUser = usersService.updateUsers(users, id);
	    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	    
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
	    usersService.deleteUsers(id);
	    return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("employees")
	public ResponseEntity<Employee> saveEmployee(Employee employee){
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED) ;
		
	}
	
}
