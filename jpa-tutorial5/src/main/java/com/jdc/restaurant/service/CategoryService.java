package com.jdc.restaurant.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.jdc.restaurant.entity.Category;

public class CategoryService {

	private EntityManager em;

	public CategoryService(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(Category category) {
		this.em.getTransaction().begin();
		this.em.persist(category);
		this.em.getTransaction().commit();
	}

	public void update(Category category) {
		this.em.getTransaction().begin();
		this.em.merge(category);
		this.em.getTransaction().commit();
	}

	public Category findById(long id) {
		return em.find(Category.class, id);
	}

	public List<Category> getAll() {
		return em.createNamedQuery("Category.getAll", Category.class).getResultList();
	}
}
