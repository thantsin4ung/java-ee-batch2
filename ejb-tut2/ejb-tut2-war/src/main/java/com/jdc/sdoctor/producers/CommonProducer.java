package com.jdc.sdoctor.producers;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.jdc.sdoctor.entity.Member.Role;
import com.jdc.sdoctor.entity.PersonalInfo.Gender;

public class CommonProducer {

	@Produces
	@Named
	public Role[] getRoles() {
		return Role.values();
	}

	@Produces
	@Named
	public Gender[] getGenders() {
		return Gender.values();
	}
}
