package com.java2.web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orderr")
public class OrderrEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "create_date")
	private String createDate;

	@Column(name = "user_name")
	private String userName;

	// @ManyToOne(fetch = FetchType.EAGER,cascade = { CascadeType.ALL})
	// @JoinColumn(name = "user_id")
	// private UserEntity userId;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "orderr_production", joinColumns = @JoinColumn(name = "orders_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "production_id", referencedColumnName = "id"))
	private List<ProductionEntity> production = new ArrayList<ProductionEntity>();

	public List<ProductionEntity> getProduction() {
		return production;
	}

	public void setProduction(List<ProductionEntity> production) {
		this.production = production;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
