package com.springboot.user.model;

 
public class User {
	private int user_id;
	private String name;
	private String email_id;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	public User(int user_id, String name, String email_id) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email_id = email_id;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
