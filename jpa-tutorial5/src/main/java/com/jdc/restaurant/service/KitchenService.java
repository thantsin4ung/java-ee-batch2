package com.jdc.restaurant.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.jdc.restaurant.entity.Kitchen;

public class KitchenService {

	private EntityManager em;

	public KitchenService(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(Kitchen kitchen) {

	}

	public void update(Kitchen kitchen) {

	}

	public List<Kitchen> getAll() {

		// TODO static query Kitchen.getAll

		return null;
	}

}
