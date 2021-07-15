package com.online.store.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.demo.model.Customer;
import com.online.store.demo.repository.CustomerRepository;

/**
 * @author rasrivastava
 * @apiNote Customer Micro-Service
 */
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;

    
    @GetMapping("/customers")
    public Object fetchCustomers()
    {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

}
