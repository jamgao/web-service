package com.java2.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dto.User;
import com.java2.web.repository.UserRepositoy;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserRepositoy userRepository;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<User> getUser() {

		return getUser();

	}
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void removeUser(User user) {
		userRepository.removeUser(user);
		
	}
	@RequestMapping(path = "/{id}",method = RequestMethod.POST)
	public void updateUser(User user){
		userRepository.updateUser(user);
	}
	@RequestMapping(path = "",method = RequestMethod.PUT)
	public void addUser(User user){
		userRepository.addUser(user);
	}
	
	
}
