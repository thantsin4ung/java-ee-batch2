package com.jdc.askmequick.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SecurityBean {

	private String loginId;
	private String password;
	private String name;

	public String login() {

		return "/home?faces-redirect=true";
	}

	public String signUp() {

		return "/home?faces-redirect=true";
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
