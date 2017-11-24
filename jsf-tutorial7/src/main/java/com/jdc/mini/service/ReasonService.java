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

import com.jdc.mini.entity.Reasons;

@Stateless
@LocalBean
public class ReasonService {

	@PersistenceContext
	private EntityManager em;

	@Inject
	private Event<Reasons> event;

	@Resource
	private SessionContext ctx;

	public List<Reasons> getAll() {
		return em.createNamedQuery("Reasons.getAll", Reasons.class).getResultList();
	}

	public void save(Reasons data) {
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
