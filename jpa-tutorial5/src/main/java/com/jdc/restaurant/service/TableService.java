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

	}

	public void update(Table table) {

	}

	public List<Table> getAll() {
		// TODO Static Query getAll
		return null;
	}
}
