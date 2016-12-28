package com.java2.web.service;

import com.java2.web.dto.User;

public interface UserService {
	
	public Iterable<User> getAllUsers();
	
	public User createUser(User user);
}
