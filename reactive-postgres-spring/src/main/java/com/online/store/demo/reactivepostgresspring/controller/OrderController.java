package com.online.store.demo.reactivepostgresspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.demo.reactivepostgresspring.model.Order;
import com.online.store.demo.reactivepostgresspring.service.OrderService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	/*
	 * Update order for single (Mono) order Id=> POST: http://localhost:8080/orders
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Order> createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}
	
	/*
	 * Update order by Id for single (Mono) PUT: http://localhost:8080/orders/{orderId}
	 */
	@PutMapping("/{orderId}")
	public Mono<ResponseEntity<Order>> updateOrder(@PathVariable Integer orderId, @RequestBody Order order) {
		return orderService.updateOrder(orderId, order).map(updatedOrder -> ResponseEntity.ok(updatedOrder))
				.defaultIfEmpty(ResponseEntity.badRequest().build());
	}

	/*
	 * Delete order by Id for single (Mono) DELETE: http://localhost:8080/orders/{orderId}
	 */
	
	@DeleteMapping("/{orderId}")
	public Mono<ResponseEntity<Void>> deleteOrder(@PathVariable Integer orderId) {
		return orderService.deleteOrder(orderId).map(r -> ResponseEntity.ok().<Void>build())
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	/*
	 * Get all orders (Flux - Many)  list => GET: http://localhost:8080/orders
	 */
	
	@GetMapping
	public Flux<Order> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	/*
	 * Get order by order id for single (Mono) => GET: http://localhost:8080/orders/{orderId}
	 */

	@GetMapping("/{orderId}")
	public Mono<ResponseEntity<Order>> getOrderById(@PathVariable Integer orderId) {
		Mono<Order> order = orderService.findById(orderId);
		return order.map(u -> ResponseEntity.ok(u)).defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	/*
	 * Get orders (Flux) by quantity => GET: http://localhost:8080/orders/qty/{qty}
	 */

	@GetMapping("/qty/{qty}")
	public Flux<Order> getUsersByQuantity(@PathVariable int qty) {
		return orderService.findOrdersByQuantity(qty);
	}

	/*
	 * Search orders (Flux) by  order ids  => POST: http://localhost:8080/orders//search/id
	 */
	@PostMapping("/search/id")
	public Flux<Order> fetchUsersByIds(@RequestBody List<Integer> orderIds) {
		return orderService.fetchOrders(orderIds);
	}
}