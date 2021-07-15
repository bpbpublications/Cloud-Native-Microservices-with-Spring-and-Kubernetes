package com.online.store.demo.ordereventdriven.model;

public class PurchaseOrder {
	private Integer id;
	private String data;
	private byte[] bytePayload;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public byte[] getBytePayload() {
		return bytePayload;
	}

	public void setBytePayload(byte[] bytePayload) {
		this.bytePayload = bytePayload;
	}
}
