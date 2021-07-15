package com.online.store.demo.ordereventdriven.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(OrderEventProducerStream.class)
public class OrderEventProducerStreamConfig {

}
