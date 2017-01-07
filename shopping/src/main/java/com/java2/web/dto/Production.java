package com.java2.web.dto;

import java.util.List;

public class Production {
private long id;
private String name;
private String price;
private List<Orderr> orderr;

public List<Orderr> getOrderr() {
	return orderr;
}
public void setOrderr(List<Orderr> orderr) {
	this.orderr = orderr;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
}
