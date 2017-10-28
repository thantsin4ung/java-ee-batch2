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
		this.em.getTransaction().begin();
		this.em.persist(kitchen);
		this.em.getTransaction().commit();
	}

	public void update(Kitchen kitchen) {
		this.em.getTransaction().begin();
		this.em.merge(kitchen);
		this.em.getTransaction().commit();
	}

	public List<Kitchen> getAll() {
		return this.em.createNamedQuery("Kitchen.getAll", Kitchen.class).getResultList();
	}

}
