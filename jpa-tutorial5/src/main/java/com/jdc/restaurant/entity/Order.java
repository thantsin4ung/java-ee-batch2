package com.jdc.restaurant.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;
import javax.persistence.OneToMany;

@Entity
@SuppressWarnings("serial")
@Table(name = "order_tbl")
public class Order implements Serializable {

	public Order() {
		security = new Security();
		orderList = new ArrayList<>();
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	private LocalDateTime odTime;

	@ManyToOne(cascade = { PERSIST, MERGE })
	private Bill bill;

	@OneToMany(mappedBy = "order", cascade = { PERSIST, MERGE }, orphanRemoval = true)
	private List<OrderDetails> orderList;

	private Security security;

	public void addOrder(OrderDetails od) {
		od.setOrder(this);
		this.orderList.add(od);
	}

	@PrePersist
	private void prePersist() {
		security.setDelFlag(false);
		security.setCreation(LocalDateTime.now());
		security.setModification(LocalDateTime.now());
	}

	public List<OrderDetails> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderDetails> orderList) {
		this.orderList = orderList;
	}

	@PreUpdate
	private void preUpdate() {
		security.setModification(LocalDateTime.now());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getOdTime() {
		return odTime;
	}

	public void setOdTime(LocalDateTime odTime) {
		this.odTime = odTime;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

}