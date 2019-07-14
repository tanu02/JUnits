package service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import repo.EmployeeRepository;

@Configuration
public class EmployeeServiceTestConfig {

	@Bean
	public EmployeeService EmployeeServiceTestBean(EmployeeRepository employeeRepository) {
		return new EmployeeService(employeeRepository);
	}
}
