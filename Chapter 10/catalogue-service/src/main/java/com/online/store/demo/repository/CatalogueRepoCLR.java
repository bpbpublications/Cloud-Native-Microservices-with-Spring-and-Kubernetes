/**
 * 
 */
package com.online.store.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.online.store.demo.model.Catalogue;

/**
 * @author rasrivastava
 *
 */

@Component
public class CatalogueRepoCLR implements CommandLineRunner {
	
	private CatalogueRepository catalogueRepository;

	@Autowired
	public CatalogueRepoCLR(CatalogueRepository catalogueRepository) {
		this.catalogueRepository = catalogueRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Warning: Values are hard-coded for POC purpose. These value should be outside the code

		catalogueRepository.save(new Catalogue("Fan", 100.50));
		catalogueRepository.save(new Catalogue("Cooler", 200.51));
		catalogueRepository.save(new Catalogue("Refrigrator", 600.00));
		catalogueRepository.save(new Catalogue("Television", 900.50));
		
		catalogueRepository.findAll().forEach(System.out::println);
	}
}

