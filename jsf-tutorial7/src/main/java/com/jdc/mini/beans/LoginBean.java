package com.jdc.mini.beans;

import javax.enterprise.inject.Model;

@Model
public class LoginBean {

	private String loginId;
	private String password;

	public String login() {
		return "/view/balance-report?faces-redirect=true";
	}

	public String logout() {
		return "/login?faces-redirect=true";
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

}
