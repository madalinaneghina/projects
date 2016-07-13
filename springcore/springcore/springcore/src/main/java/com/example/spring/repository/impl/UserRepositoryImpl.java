package com.example.spring.repository.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.stereotype.Component;

import com.example.spring.domain.User;
import com.example.spring.repository.UserRepository;

@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@Component
public class UserRepositoryImpl implements UserRepository{

	@Override
	public List<User> list() {
		System.out.println("User Repository list");
		return null;
	}

	@Override
	public User get(int id) {
		System.out.println("Get user " + id);
		return null;
	}

	@Override
	public void save(User user) {
		System.out.println("Save user");
	}
	@PostConstruct
	public void init(){
		System.out.println("postconstruct " + this);
	}

}
