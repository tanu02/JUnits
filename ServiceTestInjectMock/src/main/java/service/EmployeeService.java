package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Employee;
import repo.EmployeeRepository;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository){
		this.employeeRepository = employeeRepository;
	}
	public Employee findByName(String name) {
		return employeeRepository.findByName(name);
	}
}
