package com.jdc.hello;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.jdc.service.bean.StatelessContainerLocal;

@Model
public class StatelessMessageBean {

	private String message;

	@EJB
	private StatelessContainerLocal container;

	public String save() {

		container.add(message);

		message = "";

		return null;
	}

	@Named
	@Produces
	public List<String> getStatelessMessages() {
		return container.getMessages();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
