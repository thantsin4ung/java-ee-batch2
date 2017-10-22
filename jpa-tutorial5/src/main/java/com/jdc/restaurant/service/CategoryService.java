package com.jdc.restaurant.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.jdc.restaurant.entity.Category;
import com.jdc.restaurant.entity.Kitchen;

public class CategoryService {

	private EntityManager em;

	public CategoryService(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(Category category) {
		// TODO Create operation
	}

	public void update(Category category) {
		// TODO Update Operation
	}

	public Category findById(long id) {
		// TODO Find By Id
		return null;
	}

	public List<Category> findByKitchen(Kitchen kitchen) {
		// TODO Static Query findByKitchen

		return null;
	}
}
