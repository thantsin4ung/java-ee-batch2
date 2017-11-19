package com.jdc.mini.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.jdc.mini.entity.Balance.Type;
import com.jdc.mini.entity.Member.Role;

@ApplicationScoped
public class CommonProducer {

	@Named
	@Produces
	public Role[] getRoles() {
		return Role.values();
	}

	@Named
	@Produces
	public Type[] getBalanceTypes() {
		return Type.values();
	}
}
