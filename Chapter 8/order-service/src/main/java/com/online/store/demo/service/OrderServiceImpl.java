package com.online.store.demo.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.online.store.demo.model.Catalogue;
import com.online.store.demo.model.Customer;
import com.online.store.demo.model.PurchaseOrder;

/**
 * @author rasrivastava
 *
 */

@Service
public class OrderServiceImpl implements OrderService {

	private static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${catalogue.resource.host}")
	private String catalogueResourceHost;

	@Value("${catalogue.resource.port}")
	private String catalogueResourcePort;

	@Value("${customer.resource.host}")
	private String customerResourceHost;

	@Value("${customer.resource.port}")
	private String customerResourcePort;

	@Autowired
	private CircuitBreakerFactory<?,?> circuitBreakerFactory;

	@Override
	public List<PurchaseOrder> fetchOrdereDetails() throws URISyntaxException {

		List<Catalogue> catalogues = fetchCatalogueService();
		List<Customer> customers = fetchCustomerService();

		List<PurchaseOrder> purchaseOrders = new ArrayList<>();
		PurchaseOrder purchaseOrder;

		for (int i = 0; i < 4; i++) {
			purchaseOrder = new PurchaseOrder();

			purchaseOrder.setId(customers.get(i).getId());
			purchaseOrder.setCname(customers.get(i).getName());
			purchaseOrder.setEmail(customers.get(i).getEmail());
			purchaseOrder.setPname(catalogues.get(i).getName());
			purchaseOrder.setPrice(catalogues.get(i).getPrice());
			purchaseOrders.add(purchaseOrder);
		}
		return purchaseOrders;
	}

	/*
	 * Fetch from Catalogue Service
	 */

	@Override
	public List<Catalogue> fetchCatalogueService() throws URISyntaxException {
		List<Catalogue> catalogueList = null;

		URI catalogueUri = new URI("http://" + catalogueResourceHost + ":" + catalogueResourcePort + "/catalogue");

		try {
			logger.info("******* Calling CATALOGUE SERVICE**********catalogueUri=> " + catalogueUri);
			ResponseEntity<Catalogue[]> catalogueResponse = restTemplate.getForEntity(catalogueUri, Catalogue[].class);
			Catalogue[] catalogue = catalogueResponse.getBody();

			if (catalogueResponse.getStatusCode().is2xxSuccessful()) {
				catalogueList = Arrays.asList(catalogue);
			} else {
				logger.info("No response or Error from [CATALOGUE SERVICE]");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return catalogueList;
	}

	/*
	 * Fetch from Customer-Service
	 */

	@Override
	public List<Customer> fetchCustomerService() throws URISyntaxException {
		List<Customer> customerList = null;

		URI customerUri = new URI("http://" + customerResourceHost + ":" + customerResourcePort + "/customers");

		try {
			logger.info("******* Calling CUSTOMER SERVICE**********customerUri=> " + customerUri.toString());
			ResponseEntity<Customer[]> customerResponse = restTemplate.getForEntity(customerUri, Customer[].class);

			Customer[] customer = customerResponse.getBody();
			if (customerResponse.getStatusCode().is2xxSuccessful()) {
				customerList = Arrays.asList(customer);
			} else {
				logger.info("No response or Error from [CUSTOMER SERVICE]");
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public String fetchCatalogueServiceCircuitBreaker() throws URISyntaxException {
		String catalogueRespone = null;
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
		
		URI catalogueUri = new URI("http://" + catalogueResourceHost + ":" + catalogueResourcePort + "/catalogue");

		try {
			logger.info("******* Calling CATALOGUE SERVICE- Circuit breaker**********catalogueUri=> " + catalogueUri);
			catalogueRespone= circuitBreaker.run(() -> restTemplate.getForObject(catalogueUri, String.class), throwable -> getDefaultCatalogueList());
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return catalogueRespone;
	}

	// Circuit breaker- Fall back method if catalogue REST API won't respond
	private String getDefaultCatalogueList() {
		logger.info("******* Calling Fallback API **********");
		/*
		 * Fallback business logic goes here 
		 */
		return "Calling Fallback API";
	}

	@Override
	public List<Object> createOrdereDetails(PurchaseOrder purchaseOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> deleteOrdereDetails(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> updateOrdereDetails(String id, PurchaseOrder purchaseOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PurchaseOrder> fetchOrdereDetails(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
