package com.java2.web.service;

import java.util.List;

import com.java2.web.dto.User;

public interface UserService {	
	public List<User> getAllUsers();
	
	public void addUser(User user);
	
	public void removeUser(long userId);
	
	public void updateUser(User user);
     
	
	
}
