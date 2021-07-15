package com.online.store.demo.reactivepostgresspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.store.demo.reactivepostgresspring.dao.OrderRepository;
import com.online.store.demo.reactivepostgresspring.model.Order;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@Transactional
@Slf4j
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Mono<Order> createOrder(Order order) {
		return orderRepository.save(order);
	}

	public Mono<Order> updateOrder(Integer orderId, Order order) {
		return orderRepository.findById(orderId).flatMap(dbOrder -> {
			dbOrder.setQty(order.getQty());
			dbOrder.setPrice(order.getPrice());

			return orderRepository.save(dbOrder);
		});
	}

	public Flux<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Mono<Order> findById(Integer orderId) {
		return orderRepository.findById(orderId);
	}

	public Mono<Order> deleteOrder(Integer orderId) {
		return orderRepository.findById(orderId)
				.flatMap(existingOrder -> orderRepository.delete(existingOrder).then(Mono.just(existingOrder)));
	}

	public Flux<Order> findOrdersByQuantity(int qty) {
		return orderRepository.findByQuantity(qty);
	}

	public Flux<Order> fetchOrders(List<Integer> orderIds) {
		return Flux.fromIterable(orderIds).parallel().runOn(Schedulers.boundedElastic()).flatMap(i -> findById(i))
				.ordered((u1, u2) -> u2.getId() - u1.getId());
	}
}