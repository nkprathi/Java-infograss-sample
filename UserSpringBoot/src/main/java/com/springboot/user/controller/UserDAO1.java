package com.springboot.user.controller;

import java.util.List;

import javax.sql.DataSource;

import com.springboot.user.model.User;

public interface UserDAO1 {
	public void setDataSource(DataSource ds);
	// this method will return all
	// the details of the students
	public List<User> getAllUserDetails() ;
	
	
}
