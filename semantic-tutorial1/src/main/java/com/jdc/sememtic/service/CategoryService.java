package com.jdc.sememtic.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.sememtic.entity.Category;

@Stateless
@LocalBean
public class CategoryService {

	@PersistenceContext
	private EntityManager em;

	public List<Category> getAll() {
		return em.createQuery("select c from Category c", Category.class).getResultList();
	}

	public Object findById(long id) {
		return em.find(Category.class, id);
	}

}
