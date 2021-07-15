package com.online.store.demo.ordereventdriven.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderEventProducerStream {
	
	String OUTBOUND = "order_topic";

	@Output(OUTBOUND)
	MessageChannel producer();

}
