package com.java2.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.dto.Orderr;
import com.java2.web.dto.Production;
import com.java2.web.entity.OrderrEntity;
import com.java2.web.entity.ProductionEntity;
@Repository
public class OrderrRepo implements OrderrRepository{
	@PersistenceContext
	EntityManager em;
	@Transactional
	@Override
	public void addOrderr(Orderr orderr) {
		OrderrEntity orderrEntity = new OrderrEntity();
		orderrEntity.setCreateDate(orderr.getCreateDate());
		orderrEntity.setId(orderr.getId());
		orderrEntity.setUserName(orderr.getUserName());
		
		 for(Production p: orderr.getProduction()) {
			  ProductionEntity pe = new ProductionEntity();
	        	pe.setName(p.getName());
	        	pe.setPrice(p.getPrice());	    
	        	pe.setId(p.getId());	        
	        	orderrEntity.getProduction().add(pe);
	        }
		em.persist(orderrEntity);
	}
	@Transactional
	@Override
	public void removeOrderr(long orderrId) {
		OrderrEntity orderrEntity = em.find(OrderrEntity.class, orderrId);
		em.remove(orderrEntity);
		
	}
	@Transactional
	@Override
	public void updateOrderr(Orderr orderr) {
		OrderrEntity orderrEntity = em.find(OrderrEntity.class, orderr.getId());
		orderrEntity.setId(orderr.getId());
		orderrEntity.setCreateDate(orderr.getCreateDate());
		orderrEntity.setUserName(orderr.getUserName());
		 for(Production p: orderr.getProduction()) {
			  ProductionEntity pe = new ProductionEntity();
	        	pe.setName(p.getName());
	        	pe.setPrice(p.getPrice());	        	
	        	orderrEntity.getProduction().add(pe);
	        }
		em.merge(orderrEntity);
	}
	@Transactional
	@Override
	public List<OrderrEntity> getAllOrderr() {
		@SuppressWarnings("unchecked")
		List<OrderrEntity> allOrderr = em.createNativeQuery
				("select * from orderr", OrderrEntity.class).getResultList();
		return allOrderr;
	}
	

}
