package com.online.store.demo.springcloudtaskdemo;

import java.util.logging.Logger;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableTask
@EnableBatchProcessing
public class SpringCloudTaskDemoApplication {

	private final static Logger LOGGER = Logger.getLogger(SpringCloudTaskDemoApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTaskDemoApplication.class, args);
	}

	@Component
	public static class HelloWorldApplicationRunner implements ApplicationRunner {

		@Override
		public void run(ApplicationArguments arg0) throws Exception {
			LOGGER.info("Hello World from Spring Cloud Task!");
		}
	}
	
	 @Bean
	    public TaskListener taskListener() {
	        return new TaskListener();
	    }

}
