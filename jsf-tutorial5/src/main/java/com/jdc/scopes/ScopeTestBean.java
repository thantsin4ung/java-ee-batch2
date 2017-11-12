package com.jdc.scopes;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Model
public class ScopeTestBean {

	@Inject
	private ApplicationCounter application;
	@Inject
	private SessionCounter session;
	@Inject
	private ViewCounter view;
	@Inject
	private RequestCounter request;

	public String countUp() {
		application.getCounter().countUp();
		session.getCounter().countUp();
		view.getCounter().countUp();
		request.getCounter().countUp();
		return "";
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index?faces-redirect=true";
	}
}
