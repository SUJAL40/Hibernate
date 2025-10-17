package com.tap;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


//if you have no main class then we get for jakarta library
@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cid")
	private CustomerDetails cid;
	//cid is foreign key so not need in constructor we need of getter and setter of this
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setCid(CustomerDetails cid) {
		this.cid = cid;
	}
	
	public CustomerDetails getCid() {
		return cid;
	}

	@Override
	public String toString() {
		return id+" "+name;
	}
	
	
	
}
