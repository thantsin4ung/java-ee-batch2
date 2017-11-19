package com.jdc.mini.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.mini.entity.Category;

@Stateless
@LocalBean
public class CategoryService {

	@PersistenceContext
	private EntityManager em;

	public Category find(long id) {
		return em.find(Category.class, id);
	}

	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
