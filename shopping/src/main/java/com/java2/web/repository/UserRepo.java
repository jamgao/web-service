package com.java2.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.java2.web.dto.User;

@Repository
public class UserRepo implements UserRepositoy{
	@PersistenceContext
    EntityManager em;
	
	@Override
     public User addUser(User user){
		 em.getTransaction().begin();
		 em.persist(user);
		 em.getTransaction().commit();
		 em.close();
		return user;
	 }

	@Override
	public void removeUser(User user) {
		em.getTransaction().begin();
		User users = em.find(User.class,user.getId());
		em.remove(users);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void updateUser(User user) {
	em.getTransaction().begin();
	User users = em.find(User.class, user.getId());
	users.setId(user.getId());
	users.setName(user.getName());
	em.merge(users);
	em.getTransaction().commit();
	em.close();
	
		
	}

	@Override
	public List<User> getAllUser() {
		em.getTransaction().begin();
        @SuppressWarnings("unchecked")
		List<User>  allUsers = 
        		em.createNativeQuery("select * from user",User.class).getResultList();
    	em.getTransaction().commit();
		em.close();
		return allUsers;
	}
  
}
