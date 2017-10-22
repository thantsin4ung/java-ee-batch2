package com.jdc.restaurant.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@SuppressWarnings("serial")
@Table(name = "order_tbl")
public class Order implements Serializable {

	public Order() {
		security = new Security();
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	private LocalDateTime odTime;

	@ManyToOne
	private Bill bill;

	private Security security;

	@PrePersist
	private void prePersist() {
		security.setDelFlag(false);
		security.setCreation(LocalDateTime.now());
		security.setModification(LocalDateTime.now());
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