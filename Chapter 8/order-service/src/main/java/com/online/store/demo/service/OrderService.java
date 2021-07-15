package com.online.store.demo.service;

import java.net.URISyntaxException;
import java.util.List;

import com.online.store.demo.model.Catalogue;
import com.online.store.demo.model.Customer;
import com.online.store.demo.model.PurchaseOrder;

public interface OrderService {

	List<Catalogue> fetchCatalogueService() throws URISyntaxException;
	
	String fetchCatalogueServiceCircuitBreaker() throws URISyntaxException;

	List<Customer> fetchCustomerService() throws URISyntaxException;
	
	List<PurchaseOrder> fetchOrdereDetails() throws URISyntaxException;

	List<Object> createOrdereDetails(PurchaseOrder purchaseOrder);

	List<Object> deleteOrdereDetails(String id);

	List<Object> updateOrdereDetails(String id, PurchaseOrder purchaseOrder);

	List<PurchaseOrder> fetchOrdereDetails(String id);
}
