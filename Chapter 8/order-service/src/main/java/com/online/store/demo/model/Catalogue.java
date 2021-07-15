package com.online.store.demo.model;

/**
 * @author rasrivastava
 *
 */

public class Catalogue {

	private Long id;

	private String name;

	private Double price;

	public Catalogue() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}