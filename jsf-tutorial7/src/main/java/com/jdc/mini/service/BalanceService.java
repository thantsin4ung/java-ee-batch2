package com.jdc.mini.service;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.mini.entity.Balance;

@LocalBean
@Stateless
public class BalanceService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private SessionContext ctx;

	public void save(Balance balance) {
		balance.getSecurity().setUpdateUser(ctx.getCallerPrincipal().getName());
		if (balance.getId() == 0) {
			balance.getSecurity().setCreateUser(ctx.getCallerPrincipal().getName());
			em.persist(balance);
		} else {
			em.merge(balance);
		}

	}

	public Balance findById(long id) {
		return em.find(Balance.class, id);
	}

}
