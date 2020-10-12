package com.ordapplicationdemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordapplicationdemo.model.Customer;
import com.ordapplicationdemo.repository.CustomerRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping(value="/insertcustomer")
	public String insertEmployee(@RequestBody Customer customer) {
		customerRepository.save(customer);
		return "Customer created Sucessfully";
	}
	
}
