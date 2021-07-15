package com.online.store.demo.ordereventdriven.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.online.store.demo.ordereventdriven.model.PurchaseOrder;

@Service
public class OrderEventProducerStreamService {
	
		@Autowired
		private OrderEventProducerStream eventStream;

		public Boolean produceEvent(PurchaseOrder purchaseOrder) {
			
			System.out.println("Producing purchase order events=> id: "+ purchaseOrder.getId() +" Actual message: "+ purchaseOrder.getData());
			
			purchaseOrder.setBytePayload(purchaseOrder.getData().getBytes());
			
			//Set Message channel or topic "order_topic"
			MessageChannel messageChannel = eventStream.producer();
			
			//Send payload JSON message to Kafka message broker
			return messageChannel.send(MessageBuilder.withPayload(purchaseOrder)
					.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		}
}