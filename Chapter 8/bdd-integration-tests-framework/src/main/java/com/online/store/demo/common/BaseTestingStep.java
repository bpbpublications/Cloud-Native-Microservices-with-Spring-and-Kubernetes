package com.online.store.demo.common;

import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;

import com.online.store.demo.Application;

/**
 * This class contains common test methods
 *
 * @author rajiv.srivastava
 */
@ContextConfiguration(classes = { Application.class })
public abstract class BaseTestingStep {

	protected abstract HttpHeaders buildHeaders();
}