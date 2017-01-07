package com.java2.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dto.Orderr;
import com.java2.web.service.OrderrService;

@RestController
@RequestMapping(path = "/orderrs")
public class OrderrController {
	
	@Autowired
	private OrderrService orderrService;
	
	

	@RequestMapping(path = "",method = RequestMethod.PUT)
	public void addOrderr(@RequestBody Orderr orderr) {
		orderrService.addOrderr(orderr);		
	}
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public   List<Orderr> getOrderr() {
		return orderrService.getAllOrderr();

	}
	@RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
	public void removeOrderr(@PathVariable() long id) {
		orderrService.removeOrderr(id);		
	}
	@RequestMapping(path = "/{id}",method = RequestMethod.POST)
	public void updateOrderr(@PathVariable() Orderr id) {
		orderrService.updateOrderr(id);		
	}
	public OrderrService getOrderrService() {
		return orderrService;
	}

	public void setOrderrService(OrderrService orderrService) {
		this.orderrService = orderrService;
	}

	

}
