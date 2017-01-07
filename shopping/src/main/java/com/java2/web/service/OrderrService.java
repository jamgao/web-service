package com.java2.web.service;

import java.util.List;

import com.java2.web.dto.Orderr;

public interface OrderrService {
	public List<Orderr> getAllOrderr();

	public void addOrderr(Orderr orderr);	

	

	public void removeOrderr(long orderrId);



	public void updateOrderr(Orderr orderr);

	

	
}
