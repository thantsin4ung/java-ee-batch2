package com.jdc.mini.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.mini.entity.Category;

@Stateless
@LocalBean
public class CategoryService {

	@PersistenceContext
	private EntityManager em;

	@Inject
	private Event<Category> event;

	@Resource
	private SessionContext ctx;

	public Category find(long id) {
		return em.find(Category.class, id);
	}

	public List<Category> getAll() {
		return em.createNamedQuery("Category.getAll", Category.class).getResultList();
	}

	public void save(Category data) {
		data.getSecurity().setUpdateUser(ctx.getCallerPrincipal().getName());
		if (data.getId() == 0) {
			data.getSecurity().setCreateUser(ctx.getCallerPrincipal().getName());
			em.persist(data);
		} else {
			em.merge(data);
		}

		event.fire(data);
	}
}
