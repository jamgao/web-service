package com.java2.web.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dto.User;

@RestController
@RequestMapping(path="/users")
public class UserController {
	
	@RequestMapping(path="",method=RequestMethod.GET)
   public List<User>  getUser(){
	  User user = new User();
	  user.setId(1L);
	  user.setName("wangwu");	   
	   return Arrays.asList(user);
	   
   }
}
