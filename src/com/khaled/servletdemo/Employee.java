package com.khaled.servletdemo;

import java.util.concurrent.atomic.AtomicInteger;

public class Employee {

	
	private static AtomicInteger  idGenerator = new AtomicInteger(0);
	private int id ;
	private String firstName;
	private String lastName;
	private String title;
	
	public Employee(String firstName, String lastName, String title) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.id = idGenerator.getAndIncrement();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title + "]";
	}
	
	
	
	
}
