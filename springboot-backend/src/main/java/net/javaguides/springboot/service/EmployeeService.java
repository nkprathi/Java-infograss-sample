package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);
	
	Employee createEmployees(Employee employee);
	
	Employee getEmployeesById(Long id);
	
	List<Employee> getAllEmployees();
	
	Employee updateEmployees(Employee employee,Long id);
	
	void deleteEmployees(Long id);
}
