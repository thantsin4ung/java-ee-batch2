package com.jdc.service.bean;

import javax.ejb.Stateless;

@Stateless
public class HelloStatelessBean implements HelloStatelessBeanRemote, HelloStatelessBeanLocal {

	public HelloStatelessBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "Hello from EJB";
	}

	@Override
	public String getRemoteMessage() {
		return "Remote Message";
	}

}
