package com.tap;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Emp")
public class Employee {
	
	@Id 
	@Column(name="id")
	private int id;
	
	@Column(name="employee_name")
	private String name;
	
	//we need to tell employee which emp handle which project by list
		@ManyToMany(fetch = FetchType.EAGER,  cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
		@JoinTable(name="emp_pro",
				joinColumns = @JoinColumn(name="emp_id"),
				inverseJoinColumns = @JoinColumn(name="pro_id")			
				)
		private List<Project> projects;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name) {
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
	
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	@Override
	public String toString() {
		return id+" "+name+" ";
	}
	
	
}
