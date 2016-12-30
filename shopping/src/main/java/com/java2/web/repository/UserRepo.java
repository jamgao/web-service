package com.java2.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.dto.User;

@Repository
public class UserRepo implements UserRepositoy {
	@PersistenceContext
	EntityManager em;

	@Transactional
	@Override
	public User addUser(User user) {

		em.persist(user);

		return user;
	}

	@Transactional
	@Override
	public void removeUser(User user) {

		User users = em.find(User.class, user.getId());
		em.remove(users);

	}

	@Transactional
	@Override
	public void updateUser(User user) {

		User users = em.find(User.class, user.getId());
		users.setId(user.getId());
		users.setName(user.getName());
		users.setNickname(user.getNickname());
		users.setAddress(user.getAddress());
		users.setMailbox(user.getMailbox());
		users.setBalance(user.getBalance());
		em.merge(users);

	}

	@Transactional
	@Override
	public List<User> getAllUser() {
		@SuppressWarnings("unchecked")
		List<User> allUsers = em.createNativeQuery
		("select * from user", User.class).getResultList();

		return allUsers;
	}

}
