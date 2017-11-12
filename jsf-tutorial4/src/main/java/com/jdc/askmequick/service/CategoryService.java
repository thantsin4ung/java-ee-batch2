package com.jdc.askmequick.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.askmequick.entity.Category;

@Stateless
@LocalBean
public class CategoryService {

	@PersistenceContext
	private EntityManager em;

	@Named("categories")
	@Produces
	public List<Category> getAll() {
		return em.createNamedQuery("Category.getAll", Category.class).getResultList();
	}
}
