package com.java2.web.repository;

import java.util.List;

import com.java2.web.dto.User;

public interface UserRepositoy {
public  User addUser(User user);
public  void removeUser(User user);
public  void updateUser(User user);
public  List<User> getAllUser();
 
}
