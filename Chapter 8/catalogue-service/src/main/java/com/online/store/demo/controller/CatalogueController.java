package com.online.store.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.demo.model.Catalogue;
import com.online.store.demo.repository.CatalogueRepository;

/**
 * @author rasrivastava
 *
 */
@RestController
public class CatalogueController {
	
	@Autowired
	private CatalogueRepository catalogueRepository;

    @GetMapping("/catalogue")
    public Object fetchProducts ()
    {
        List<Catalogue> products = catalogueRepository.findAll();
        return products;
    }

}
