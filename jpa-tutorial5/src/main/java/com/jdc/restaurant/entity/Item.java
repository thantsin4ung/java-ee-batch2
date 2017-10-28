package com.jdc.restaurant.entity;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
@SuppressWarnings("serial")
public class Item implements Serializable {

	public Item() {
		security = new Security();
		prices = new ArrayList<>();
	}

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

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	private String name;

	private String image;

	@ManyToOne
	private Category category;

	@ManyToOne
	private Kitchen kitchen;

	@OneToMany(mappedBy = "item", cascade = { PERSIST, MERGE }, orphanRemoval = true, fetch = EAGER)
	private List<ItemPrice> prices;

	private Security security;

	public void addItemPrice(ItemPrice p) {
		prices.add(p);
		p.setItem(this);
	}

	public Kitchen getKitchen() {
		return kitchen;
	}

	public void setKitchen(Kitchen kitchen) {
		this.kitchen = kitchen;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ItemPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<ItemPrice> prices) {
		this.prices = prices;
	}

}