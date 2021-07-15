package com.online.store.demo.ordereventdriven.stream;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

import com.online.store.demo.ordereventdriven.model.Message;

@Configuration
public class OrderEventConsumerStreamService {
	
	@StreamListener(OrderEventConsumerStream.INBOUND)
	public void consumeEvent(@Payload Message msg) {
		
		System.out.println("Inbound purchase order message consumed ==> id: " + msg.getId() + " Purchase Order message: "
				+ msg.getData() + " bytePayload: " + msg.getBytePayload());
	}
}