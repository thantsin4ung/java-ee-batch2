package com.jdc.sememtic.producer;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.sememtic.entity.Member;
import com.jdc.sememtic.service.MemberService;

@SessionScoped
public class LoginUserProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Named
	@Produces
	private Member loginUser;

	@Inject
	private MemberService service;

	public void load(@Observes String email) {
		loginUser = service.find(email);
	}

}
