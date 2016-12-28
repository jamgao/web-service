package com.java2.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java2.web.dto.User;
import com.java2.web.repository.UserRepositoy;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepositoy userRepository;
	
	@Override
	public List<User> getAllUsers() {
		
		return userRepository.getAllUser();
	}

	@Override
	public User createUser(User user) {
		
		return userRepository.addUser(user);
	}

}
