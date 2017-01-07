package com.java2.web.repository;

import java.util.List;

import com.java2.web.dto.Orderr;
import com.java2.web.entity.OrderrEntity;

public interface OrderrRepository {
	public void addOrderr(Orderr orderr);

	

	public List<OrderrEntity> getAllOrderr();

	public void removeOrderr(long orderrId);

	public void updateOrderr(Orderr orderr);

	
}
