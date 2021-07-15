package com.online.store.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author rasrivastava
 *
 */

public class PurchaseOrder {
	
    private Long id;

    @NotBlank
    @Size(min = 0, max = 30)
    private String cname;
    
    @NotBlank
    @Size(min = 0, max = 40)
    private String email;
    
    private String pname;
    
    private Double price;
    
    public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(String cname, String email, String pname, Double price) {
		this.cname = cname;
		this.email = email;
		this.pname = pname;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", cname=" + cname + ", email=" + email + ", pname=" + pname + ", price="
				+ price + "]";
	}
}