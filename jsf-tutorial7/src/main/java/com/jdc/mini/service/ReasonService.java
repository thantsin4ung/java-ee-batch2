package com.jdc.mini.service;

import java.util.List;

import javax.ejb.LocalBean;
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

	public List<Reasons> getAll() {
		return em.createNamedQuery("Reasons.getAll", Reasons.class).getResultList();
	}

	public void save(Reasons data) {
		if (data.getId() == 0) {
			em.persist(data);
		} else {
			em.merge(data);
		}

		event.fire(data);
	}
}
