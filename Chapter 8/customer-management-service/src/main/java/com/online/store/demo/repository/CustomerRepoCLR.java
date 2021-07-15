package com.online.store.demo.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.online.store.demo.model.Customer;

/**
 * @author rasrivastava
 *
 */

@Component
public class CustomerRepoCLR implements CommandLineRunner {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerRepoCLR(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		customerRepository.save(new Customer("Rajiv Srivastava", "rajiv@test.com"));
		customerRepository.save(new Customer("Scott Peter ", "scott@test.com"));
		customerRepository.save(new Customer("John Stevens", "john@test.com"));
		customerRepository.save(new Customer("Sharad Verma", "sharad@test.com"));
		
		customerRepository.findAll().forEach(System.out::println);
	}
}

