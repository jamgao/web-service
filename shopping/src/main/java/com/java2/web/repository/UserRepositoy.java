package com.java2.web.repository;

import java.util.List;

import com.java2.web.dto.User;
import com.java2.web.entity.UserEntity;

public interface UserRepositoy {
	public void addUser(User user);

	public void removeUser(long userId);

	public void updateUser(User user);

	public List<UserEntity> getAllUsers();

	

}
