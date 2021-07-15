package com.online.store.demo.common;
/**
 * This class contains API URIs
 *
 * @author rajiv.srivastava
 */
public enum ApiEnum {
	ORDERS_API("/orders"),
	CATALOGUES_API("/catalogues"),
	DEV_ENV("application-dev.properties"), 
	LOCAL_ENV("application-default.properties");

	private String value;

	ApiEnum(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
