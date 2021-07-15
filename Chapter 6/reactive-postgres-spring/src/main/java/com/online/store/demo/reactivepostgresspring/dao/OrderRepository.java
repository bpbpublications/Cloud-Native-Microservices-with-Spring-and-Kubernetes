package com.online.store.demo.reactivepostgresspring.dao;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.online.store.demo.reactivepostgresspring.model.Order;

import reactor.core.publisher.Flux;

public interface OrderRepository extends ReactiveCrudRepository<Order, Integer> {

	@Query("select * from orders where qty >= $1")
	Flux<Order> findByQuantity(int qty);
}