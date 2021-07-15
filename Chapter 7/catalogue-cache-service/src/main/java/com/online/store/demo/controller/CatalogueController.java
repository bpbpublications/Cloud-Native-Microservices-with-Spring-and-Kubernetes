package com.online.store.demo.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.demo.model.Catalogue;
import com.online.store.demo.repository.CatalogueRepository;

/**
 * @author rasrivastava
 *
 */
@RestController
public class CatalogueController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private CatalogueRepository catalogueRepository;

	//Cache catalogue object for feteched id as a Redis catalogues key 
	@Cacheable(value = "catalogues", key = "#id")
	@GetMapping("/catalogue/{id}")
	public Optional<Catalogue> fetchCatalogue(@PathVariable Long id) {
		LOG.info("Getting user with ID {}.", id);
		return catalogueRepository.findById(id);
	}
	
	//Updating Cache
	@Cacheable(value = "catalogues", key = "#id")
	@PutMapping("/catalogue/update}")
	public Catalogue updateCatalogue(@RequestBody Catalogue catalogue) {
		catalogueRepository.save(catalogue);
		LOG.info("Updated Catalogue");
		return catalogue;
	}
	
	//Clear Cache
	@CacheEvict(value = "catalogues", key = "#id")
	@DeleteMapping("/catalogue/{id}")
	public void deleteUserByID(@PathVariable Long id) {
	  LOG.info("deleting catalogue with id {}", id);
	  catalogueRepository.deleteById(Long.valueOf(id));
	}
}