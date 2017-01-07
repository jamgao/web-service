package com.java2.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.dto.Address;
import com.java2.web.dto.User;
import com.java2.web.entity.AddressEntity;
import com.java2.web.entity.UserEntity;

@Repository
public class UserRepo implements UserRepositoy {
	@PersistenceContext
	EntityManager em;

	@Transactional
	@Override
	public void addUser(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setBalance(user.getBalance());
		userEntity.setMailbox(user.getMailbox());
		userEntity.setName(user.getName());
		userEntity.setNickname(user.getNickname());
		userEntity.setId(user.getId());
		

		for (Address ad : user.getAddress()) {
			AddressEntity ae = new AddressEntity();
			ae.setCountry(ad.getCountry());
			ae.setUserId(userEntity);
			userEntity.getAddress().add(ae);
		}
		em.persist(userEntity);
	}

	@Transactional
	@Override
	public void removeUser(long userId) {

		UserEntity userEntity = em.find(UserEntity.class, userId);

		em.remove(userEntity);

	}

	@Transactional
	@Override
	public void updateUser(User user) {

		UserEntity userEntity = em.find(UserEntity.class, user.getId());
		userEntity.setId(user.getId());
		userEntity.setName(user.getName());
		userEntity.setNickname(user.getNickname());
		userEntity.setMailbox(user.getMailbox());
		userEntity.setBalance(user.getBalance());
	
		for (Address ad : user.getAddress()) {
			AddressEntity ae = new AddressEntity();
			ae.setCountry(ad.getCountry());
			userEntity.getAddress().add(ae);
		}
		em.merge(userEntity);

	}

	@Transactional
	@Override
	public List<UserEntity> getAllUsers() {
		@SuppressWarnings("unchecked")
		List<UserEntity> allUsers = em.createNativeQuery("select * from users", UserEntity.class).getResultList();

		return allUsers;
	}

}
