package com.jdc.restaurant.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jdc.restaurant.RestaurantException;
import com.jdc.restaurant.entity.Account;
import com.jdc.restaurant.entity.Account.Role;

public class AccountService {

	private EntityManager em;

	public AccountService(EntityManager em) {
		super();
		this.em = em;
	}

	public void createAccount(Account a) {
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}

	public Account login(String loginId, String password) {

		Account ac = em.find(Account.class, loginId);

		if (null == ac) {
			throw new RestaurantException("Please check Login ID.");
		}

		if (!ac.getPass().equals(password)) {
			throw new RestaurantException("Please check your password!");
		}

		return ac;
	}

	public List<Account> findByRole(Role role) {
		TypedQuery<Account> q = em.createNamedQuery("Account.findByRole", Account.class);
		q.setParameter("role", role);
		return q.getResultList();
	}

	public void update(Account account) {

		em.getTransaction().begin();
		em.merge(account);
		em.getTransaction().commit();

	}
}
