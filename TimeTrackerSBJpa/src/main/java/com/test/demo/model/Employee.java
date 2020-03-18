package com.test.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeTime")
public class Employee {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String location;
	private String designation;
	private String swipeIn;
	private String swipeOut;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getSwipeIn() {
		return swipeIn;
	}
	public void setSwipeIn(String swipeIn) {
		this.swipeIn = swipeIn;
	}
	public String getSwipeOut() {
		return swipeOut;
	}
	public void setSwipeOut(String swipeOut) {
		this.swipeOut = swipeOut;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", location=" + location + ", designation=" + designation
				+ ", swipeIn=" + swipeIn + ", swipeOut=" + swipeOut + "]";
	}
	
	
	
}
