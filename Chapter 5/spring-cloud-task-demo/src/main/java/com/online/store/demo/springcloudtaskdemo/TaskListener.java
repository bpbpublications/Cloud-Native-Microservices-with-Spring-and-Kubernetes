package com.online.store.demo.springcloudtaskdemo;

import java.util.logging.Logger;

import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

public class TaskListener implements TaskExecutionListener {

	private final static Logger LOGGER = Logger.getLogger(TaskListener.class.getName());

	@Override
	public void onTaskEnd(TaskExecution arg0) {
		LOGGER.info("Task completed!");
	}

	@Override
	public void onTaskFailed(TaskExecution arg0, Throwable arg1) {
		LOGGER.info("Task failed!");

	}

	@Override
	public void onTaskStartup(TaskExecution arg0) {
		LOGGER.info("Task Started!");
	}
}
