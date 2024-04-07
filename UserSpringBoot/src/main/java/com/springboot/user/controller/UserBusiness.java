package com.springboot.user.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.user.model.User;

@Component
public class UserBusiness {
	@Autowired
	UserDAO userdao;
	
	public boolean createUser(User u) {
		return userdao.createUser(u);
	}
}
