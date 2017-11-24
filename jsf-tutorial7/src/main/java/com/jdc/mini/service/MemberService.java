package com.jdc.mini.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.mini.entity.Member;

@LocalBean
@Stateless
public class MemberService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private SessionContext ctx;

	public List<Member> getAll() {
		return em.createNamedQuery("Member.getAll", Member.class).getResultList();
	}

	public void save(Member member) {
		Member old = em.find(Member.class, member.getEmail());
		member.getSecurity().setUpdateUser(ctx.getCallerPrincipal().getName());
		if (null != old) {
			member.getSecurity().setCreateUser(ctx.getCallerPrincipal().getName());
			em.merge(member);
		} else {
			member.setPassword(PasswordUtils.encript(member.getPassword()));
			em.persist(member);
		}
	}

	public void changePassword(Member member) {
		member.setPassword(PasswordUtils.encript(member.getPassword()));
		save(member);
	}

	public Member findById(String loginId) {
		// TODO Auto-generated method stub
		return null;
	}

}
