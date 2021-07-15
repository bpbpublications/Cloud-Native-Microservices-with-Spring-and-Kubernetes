package com.online.store.demo.ordereventdriven.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.demo.ordereventdriven.model.PurchaseOrder;
import com.online.store.demo.ordereventdriven.stream.OrderEventProducerStreamService;

/**
 * @author rasrivastava
 * @apiNote Order event driven Micro-Service
 */
@RestController
@RequestMapping("/orders")
public class OrderController {


	@Autowired
	private OrderEventProducerStreamService orderEventProducerStreamService;

	@PostMapping("/produce")
	public Boolean createOrders(@RequestBody final PurchaseOrder purchaseOrder) throws URISyntaxException {
		return orderEventProducerStreamService.produceEvent(purchaseOrder);
	}
}