
package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Employee;
import service.DiscountService;

@RestController
public class DiscountController {

	@Autowired
	DiscountService discountService;

	@Autowired
	public DiscountController(DiscountService discountService) {
		this.discountService = discountService;
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Employee> findAll() {
		List<Employee> employees = discountService.findListByName("");
		return employees;
	}

	@RequestMapping(value = "/findOne", method = RequestMethod.GET)
	public Employee findOne() {
		Employee employee = discountService.findByName("");
		return employee;
	}

	@RequestMapping("/")
	public @ResponseBody String greeting() {
		return "Hello World";
	}

}