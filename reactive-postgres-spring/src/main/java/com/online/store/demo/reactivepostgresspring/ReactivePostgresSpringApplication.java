package com.online.store.demo.reactivepostgresspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import io.r2dbc.spi.ConnectionFactory;

@SpringBootApplication
public class ReactivePostgresSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactivePostgresSpringApplication.class, args);
	}
	
	@Bean
	public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
		populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("order-schema.sql")));
		initializer.setDatabasePopulator(populator);
		return initializer;
	}
}