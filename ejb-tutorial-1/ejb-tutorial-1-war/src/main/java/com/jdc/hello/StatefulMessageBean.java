package com.jdc.hello;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.jdc.service.bean.StatefulContainerLocal;

@Model
@SessionScoped
public class StatefulMessageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;

	@EJB
	private StatefulContainerLocal container;

	public String save() {
		container.add(message);
		return null;
	}

	@Named
	@Produces
	public List<String> getStatefulMessages() {
		return container.getAll();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
