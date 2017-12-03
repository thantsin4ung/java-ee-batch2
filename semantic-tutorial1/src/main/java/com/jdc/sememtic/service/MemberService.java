package com.jdc.sememtic.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.sememtic.entity.Member;

@Stateless
@LocalBean
public class MemberService {

	@PersistenceContext
	private EntityManager em;

	public void create(Member member) {
		em.persist(member);
	}

	public Member find(String email) {
		return em.find(Member.class, email);
	}
}
