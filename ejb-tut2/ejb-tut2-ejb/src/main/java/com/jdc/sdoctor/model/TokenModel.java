package com.jdc.sdoctor.model;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.sdoctor.entity.Token;

@LocalBean
@Stateless
public class TokenModel {

	@EJB
	private TokenNumberGenerator generator;

	@PersistenceContext
	private EntityManager em;

	public void takeToken(Token token) {
		token.setQueueNumber(generator.getToken());
		em.persist(token);
	}

	public List<Token> find(LocalDate date) {
		return em.createNamedQuery("Token.findByDate", Token.class).setParameter("date", date).getResultList();
	}
}
