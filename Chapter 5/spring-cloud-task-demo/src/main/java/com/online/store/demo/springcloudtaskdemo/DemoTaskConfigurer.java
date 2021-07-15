package com.online.store.demo.springcloudtaskdemo;

import javax.sql.DataSource;

import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;

public class DemoTaskConfigurer extends DefaultTaskConfigurer {

	public DemoTaskConfigurer(DataSource dataSource) {
		super(dataSource);
	}

}
