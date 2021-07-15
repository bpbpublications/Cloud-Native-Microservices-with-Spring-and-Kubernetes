package com.online.store.demo.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.demo.model.PurchaseOrder;
import com.online.store.demo.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * @author rasrivastava
 * @apiNote Order Micro-Service
 */
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/orders")
	public List<PurchaseOrder> fetchOrders() throws URISyntaxException {
		List<PurchaseOrder> orders = orderService.fetchOrdereDetails();
		return orders;
	}

	//Test Spring Cloud Circuit breaker using Resileince4j
	@GetMapping("/catalogues")
	public String fetchCatalogue() throws URISyntaxException {
		return orderService.fetchCatalogueServiceCircuitBreaker();
	}

	@PostMapping("/orders")
	public List<Object> postOrders(@RequestBody final PurchaseOrder purchaseOrder)
			throws URISyntaxException {
		List<Object> orders = orderService.createOrdereDetails(purchaseOrder);
		return orders;
	}

	@DeleteMapping("/orders/{id}")
	public List<Object> deleteOrders(@PathVariable("id") final String id) throws URISyntaxException {
		List<Object> orders = orderService.deleteOrdereDetails(id);
		return orders;
	}

	@PutMapping("/orders/{id}")
	public List<Object> updateOrders(@PathVariable("id") final String id,
			@RequestBody final PurchaseOrder purchaseOrder) throws URISyntaxException {
		List<Object> orders = orderService.updateOrdereDetails(id, purchaseOrder);
		return orders;
	}

	@Operation(summary = "Get order by id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the book", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = PurchaseOrder.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Order not found", content = @Content) })
	@GetMapping("/orders/{id}")
	public List<PurchaseOrder> getOrderById(
			@Parameter(description = "order id to be searched") @PathVariable("id") final String id)
			throws URISyntaxException {
		List<PurchaseOrder> orders = orderService.fetchOrdereDetails(id);
		return orders;
	}

}