package com.jdc.rest.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless
public class MemberModel {

	@PersistenceContext
	private EntityManager em;

	public List<Member> getAll() {
		String sql = "select m from Member m";
		return em.createQuery(sql, Member.class).getResultList();
	}

	public Member findById(int i) {
		return em.find(Member.class, i);
	}

	public List<Member> findByNameLike(String name) {
		String sql = "select m from Member m where m.name like :name";
		return em.createQuery(sql, Member.class).setParameter("name", name.concat("%")).getResultList();
	}

	public List<Member> findByPhone(String phone) {
		return em.createQuery("select m from Member m where m.phone = :phone", Member.class)
				.setParameter("phone", phone)
				.getResultList();
	}

	public void create(Member member) {
		em.persist(member);
	}

	public void update(Member member) {
		em.merge(member);		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
