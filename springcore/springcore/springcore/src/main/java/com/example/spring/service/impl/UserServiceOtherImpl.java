package com.example.spring.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.spring.config.Config;
import com.example.spring.domain.User;
import com.example.spring.repository.UserRepository;
import com.example.spring.service.UserService;

@Service("service2")
public class UserServiceOtherImpl implements UserService, ApplicationContextAware{

	private ApplicationContext context;
	private UserRepository userRepository;
	
	
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		System.out.println("UserService other impl list");
		userRepository.list();
		return null;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub

		System.out.println("UserService other impl get " + id);
		userRepository.get(id);
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		System.out.println("UserService other impl save");
		userRepository.save(user);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		context = arg0;
	}
	
	@PostConstruct
	public void initUserRepository() throws Exception{
		userRepository = context.getBean(UserRepository.class);
	}
	
	

}
