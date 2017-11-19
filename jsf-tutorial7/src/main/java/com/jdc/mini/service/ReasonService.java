package com.jdc.mini.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.mini.entity.Reasons;

@Stateless
@LocalBean
public class ReasonService {

	@PersistenceContext
	private EntityManager em;

	public List<Reasons> getAll() {
		return em.createNamedQuery("Reasons.getAll", Reasons.class).getResultList();
	}
}
