package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Employee;

@Service
public class DiscountService {

	public List<Employee> findListByName(String name) {
		return new ArrayList<>();
	}

	public Employee findByName(String name) {
		return new Employee();
	}
}