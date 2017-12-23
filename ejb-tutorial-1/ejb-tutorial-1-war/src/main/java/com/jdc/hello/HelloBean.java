package com.jdc.hello;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.jdc.service.bean.CounterBean;
import com.jdc.service.bean.HelloStatelessBeanLocal;
import com.jdc.service.bean.HelloStatelessBeanRemote;

@Model
public class HelloBean {

	@EJB
	private HelloStatelessBeanLocal local;

	@EJB
	private HelloStatelessBeanRemote remote;

	@EJB
	private CounterBean counter;

	@Named
	@Produces
	public String getLocalMessage() {
		return local.getMessage();
	}

	@Named
	@Produces
	public String getRemoteMessage() {
		return remote.getRemoteMessage();
	}

	public String countUp() {
		counter.countUp();
		return null;
	}

	public int getCount() {
		return counter.getCount();
	}
}
