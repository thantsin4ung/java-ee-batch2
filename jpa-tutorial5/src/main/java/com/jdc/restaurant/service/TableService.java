package com.jdc.restaurant.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.jdc.restaurant.entity.Table;

public class TableService {

	private EntityManager em;

	public TableService(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(Table table) {
		this.em.getTransaction().begin();
		this.em.persist(table);
		this.em.getTransaction().commit();
	}

	public void update(Table table) {
		this.em.getTransaction().begin();
		this.em.merge(table);
		this.em.getTransaction().commit();
	}

	public List<Table> getAll() {
		return this.em.createNamedQuery("Table.getAll", Table.class).getResultList();
	}
}
