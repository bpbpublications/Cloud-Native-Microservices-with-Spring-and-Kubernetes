package com.online.store.demo.ordereventdriven.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface OrderEventConsumerStream {
	
	String INBOUND = "order_topic";

	@Input(INBOUND)
	SubscribableChannel consumer();
}
