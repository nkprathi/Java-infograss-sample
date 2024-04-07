package net.javaguides.springboot.service;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;


	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee getEmployeesById(Long id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		return optionalEmployee.get();
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee updateEmployees(Employee employees,Long id) {
		Optional<Employee> existingUsers = employeeRepository.findById(id);
		Employee employeeToBeUpdated = existingUsers.get();
		employeeToBeUpdated.setFirstName(employees.getFirstName());
		employeeToBeUpdated.setLastName(employees.getLastName());
		employeeToBeUpdated.setEmail(employees.getEmail());
		
		Employee updatedEmployee = employeeRepository.save(employeeToBeUpdated);
		return updatedEmployee;
	}
	
	@Override
	public void deleteEmployees(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);

	}


	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


}
