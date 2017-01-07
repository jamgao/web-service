package com.java2.web.dto;

import java.util.List;

public class Orderr {
	private long id;
	private String createDate;
	private String userName;
	private List<Production> production;

	
	
	public List<Production> getProduction() {
		return production;
	}

	public void setProduction(List<Production> production) {
		this.production = production;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
