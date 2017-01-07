package com.java2.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java2.web.dto.Orderr;
import com.java2.web.dto.Production;
import com.java2.web.entity.OrderrEntity;
import com.java2.web.entity.ProductionEntity;
import com.java2.web.repository.OrderrRepository;
@Service
public class OrderrServiceImpl implements OrderrService{
   @Autowired
   private OrderrRepository orderrRepository;
	@Override
	public List<Orderr> getAllOrderr() {
		List<OrderrEntity> orderrEntity = orderrRepository.getAllOrderr();
		List<Orderr> orderrs = new ArrayList<>();
		
		for (OrderrEntity orderr : orderrEntity) {
			Orderr orderrss = new Orderr();
			orderrss.setCreateDate(orderr.getCreateDate());
			orderrss.setUserName(orderr.getUserName());
			orderrss.setId(orderr.getId());
			
			 List<Production> productionList = new ArrayList<>();
			 
			 List<ProductionEntity> productionEntityList = orderr.getProduction();
			 
			 for(ProductionEntity productionEntity:productionEntityList){
				 
				 Production production = new Production();
				 
				 production.setName(productionEntity.getName());
				 
				 production.setPrice(productionEntity.getPrice());
				 production.setId(productionEntity.getId());
				 
				 productionList.add(production);
				
				 
			 }
			 
			 orderrss.setProduction(productionList);
			 orderrs.add(orderrss);
			
		}
		return orderrs;
	}

	
	@Override
	public void addOrderr(Orderr orderr) {
		orderrRepository.addOrderr(orderr);
		
	}
	@Override
	public void removeOrderr(long orderrId) {
		orderrRepository.removeOrderr(orderrId);
		
	}
	@Override
	public void updateOrderr(Orderr  orderr) {
		orderrRepository.updateOrderr(orderr);
		
	}

	

}
