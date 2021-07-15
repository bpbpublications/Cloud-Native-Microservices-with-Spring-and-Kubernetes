package com.online.store.demo;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}
	
	/*
	 * Global circuit breaker custom configuration
	 */
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> globalCustomConfiguration() {

		// Timeout duration= 4 seconds
		TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build();

		/* Threshold time= 50%
		 * Configures the failure rate threshold in percentage. If the failure rate is
		 * equal to or greater than the threshold, the CircuitBreaker transitions to
		 * open and starts short-circuiting calls.The threshold must be greater than 0
		 * and not greater than 100. Default value is 50 percentage.
		 * 
		 * Wait duration: 1000 ms
		 * waitDurationInOpenState the wait duration which specifies how long the CircuitBreaker should stay open

		 * slidingWindowSize= 2
		 * slidingWindowSize the size of the sliding window when the CircuitBreaker is closed.
		 */

		CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom().failureRateThreshold(50)
				.waitDurationInOpenState(Duration.ofMillis(1000)).slidingWindowSize(2).build();

		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
				.timeLimiterConfig(timeLimiterConfig).circuitBreakerConfig(circuitBreakerConfig).build());
	}
}
