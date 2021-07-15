package com.online.store.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.demo.model.Catalogue;
import com.online.store.demo.repository.CatalogueRepository;

/**
 * @author rasrivastava
 *
 */
@RestController
@RefreshScope
public class CatalogueController {

	private static final Logger logger = LoggerFactory.getLogger(CatalogueController.class);

	@Autowired
	private CatalogueRepository catalogueRepository;

	@GetMapping("/products")
	public Object fetchProducts() {
		List<Catalogue> products = catalogueRepository.findAll();
		logger.info("**Calling product catalogue ");
		return products;
	}

	@Value("${myenv.name:Config server issue}")
	private String envName;

	@GetMapping("/checkEnvName")
	public String getMyEnv() {
		return this.envName;
	}
}
