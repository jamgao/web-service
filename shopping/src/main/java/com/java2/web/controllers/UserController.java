package com.java2.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dto.User;
import com.java2.web.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "",method = RequestMethod.PUT)
	public void addUser(@RequestBody User user){
		userService.addUser(user);
	}
	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<User> getUser() {
		return userService.getAllUsers();
	}
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void removeUser(@PathVariable() long id) {
		userService.removeUser(id);

	}
	@RequestMapping(path = "",method = RequestMethod.POST)
	public void updateUser(@RequestBody User user){
		userService.updateUser(user);
	}

	public UserService getUserservice() {
		return userService;
	}

	public void setUserservice(UserService userservice) {
		this.userService = userservice;
	}

	

}
