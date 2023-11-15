package com.app.ms.orders.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable=false, name="cust_name")
	private String customerName;
	
	@Column(nullable=false, name="cust_email")
	private String customerEmail;
	
	@OneToMany(mappedBy = "order")
	private Set<OrderItem> orederItems;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Set<OrderItem> getOrederItems() {
		return orederItems;
	}

	public void setOrederItems(Set<OrderItem> orederItems) {
		this.orederItems = orederItems;
	}
	
	
	
}
