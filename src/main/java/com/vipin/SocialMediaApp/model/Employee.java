package com.vipin.SocialMediaApp.model;

public class Employee {
	
	private int id;
	private String firstname;
	private String lastname;
	
	public Employee(int id,String firstname,String lastname)
	{
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	

}
