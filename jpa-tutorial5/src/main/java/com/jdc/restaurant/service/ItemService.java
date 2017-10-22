package com.jdc.restaurant.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.jdc.restaurant.entity.Category;
import com.jdc.restaurant.entity.Item;
import com.jdc.restaurant.entity.Kitchen;

public class ItemService {

	private EntityManager em;

	public ItemService(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(Item item) {
		// TODO Consider About Item Prices
	}

	public void update(Item item) {
		// TODO Consider About Item Prices
	}

	public Item findById(long id) {
		return null;
	}

	public List<Item> findByCategory(Category cat) {
		// TODO Static Query Item.findByCategory

		return null;
	}

	public List<Item> findByKitchen(Kitchen k) {
		// TODO Static Query Item.findByKitchen

		return null;
	}

}
