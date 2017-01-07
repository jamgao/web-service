package com.java2.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java2.web.dto.Address;
import com.java2.web.dto.User;
import com.java2.web.entity.AddressEntity;
import com.java2.web.entity.UserEntity;
import com.java2.web.repository.UserRepositoy;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepositoy userRepository;

	@Override
	public List<User> getAllUsers() {
       
		List<UserEntity> userEntityList = userRepository.getAllUsers();
		List<User> users = new ArrayList<>();
		for (UserEntity user : userEntityList) {
			User useres = new User();
			 useres.setBalance(user.getBalance());
			 useres.setMailbox(user.getMailbox());
			 useres.setName(user.getName());
			 useres.setId(user.getId());
			 useres.setNickname(user.getNickname());
			
			 List<Address> addressList = new ArrayList<>();
			 
			 List<AddressEntity> addressEntityList = user.getAddress();
			 
			 for(AddressEntity addressEntity:addressEntityList){
				 
				 Address address = new Address();
				 
				 address.setCountry(addressEntity.getCountry());
				 address.setId(addressEntity.getId());
				 address.setUserId(user.getId());
				 addressList.add(address);
			 }
			 useres.setAddress(addressList);
			 users.add(useres);
			
		}
		return users;
	}



	@Override
	public void addUser(User user) {

		userRepository.addUser(user);
	}

	@Override
	public void removeUser(long userId) {

		userRepository.removeUser(userId);
		

	}

	@Override
	public void updateUser(User user) {
		userRepository.updateUser(user);

	}



	

}
