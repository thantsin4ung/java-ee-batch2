package com.jdc.sdoctor.model;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.sdoctor.entity.Member;
import com.jdc.sdoctor.utils.SmartDoctorException;

@LocalBean
@Stateless
public class SecurityModel {

	@PersistenceContext
	private EntityManager em;

	public void signUp(String name, String loginId, String password) {

		// validate
		if (null != em.find(Member.class, loginId)) {
			throw new SmartDoctorException("SMDE_0002");
		}

		Member member = new Member();
		member.setName(name);
		member.setLoginId(loginId);
		member.setPassword(password);
		em.persist(member);
	}
}
