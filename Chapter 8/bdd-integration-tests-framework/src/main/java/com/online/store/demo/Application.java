package com.online.store.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.online.store.demo.common.ApiEnum;

/**
 * This class contains main Spring Boot class
 *
 * @author rajiv.srivastava
 */
@SpringBootApplication
public class Application {
	
	private static final Resource[] DEV_PROPERTIES = new ClassPathResource[] {
			new ClassPathResource(ApiEnum.DEV_ENV.value()) };
	private static final Resource[] LOCAL_DEFAULT_PROPERTIES = new ClassPathResource[] {
			new ClassPathResource(ApiEnum.LOCAL_ENV.value()) };


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/*
	 * Environment profiling
	 */

	@Profile("dev")
	public static class DevConfig {
		@Bean
		public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
			PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
			pspc.setLocations(DEV_PROPERTIES);
			pspc.setIgnoreUnresolvablePlaceholders(true);
			return pspc;
		}
	}

	@Profile("default")
	public static class ProdConfig {
		@Bean
		public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
			PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
			pspc.setLocations(LOCAL_DEFAULT_PROPERTIES);
			return pspc;
		}
	}
}