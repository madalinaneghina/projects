package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.spring.domain.User;
import com.example.spring.service.UserService;

public class UserController {
	@Autowired
	@Qualifier("service2")
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void createUser(User user){
		// call UserService here
		userService.save(user);
	}
	public void getUser(int id){
		userService.get(id);
		System.out.println("get user");
		
	}
}
