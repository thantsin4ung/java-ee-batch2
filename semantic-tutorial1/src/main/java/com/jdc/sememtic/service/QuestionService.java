package com.jdc.sememtic.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.sememtic.entity.Question;

@LocalBean
@Stateless
public class QuestionService {

	@PersistenceContext
	private EntityManager em;

	public void save(Question question) {
		if(question.getId() > 0) {
			em.merge(question);
		} else {
			em.persist(question);
		}
	}
}
