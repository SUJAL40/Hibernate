package com.tap;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Orders")
public class Orders {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="item")
	private String item;
	
	@Column(name="price")
	private int price;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "cust_id")
	private Customer customer;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(int id, String item, int price) {
		super();
		this.id = id;
		this.item = item;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	 
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	@Override
	public String toString() {
		return "Orders :: id=" + id + ", item=" + item + ", price=" + price;
	}
	
}
