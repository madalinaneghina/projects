package com.example.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.example.spring.config.Config;
import com.example.spring.domain.User;
import com.example.spring.repository.UserRepository;
import com.example.spring.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> list() {
		//call method from UserRepository and remove throw
		System.out.println("User Service impl list");
		return null;
	}

	@Override
	public User get(int id) {
		//call method from UserRepository and remove throw
		System.out.println("User service impl get " + id);
		
		userRepository.get(id);
		return new User();
	}

	@Override
	public void save(User user) {
		//call method from UserRepository and remove throw
		System.out.println("User service impl save");
		
		userRepository.save(user);
	}
}
