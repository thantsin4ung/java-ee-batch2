package com.jdc.mini.beans;

public class LoginBean {

	private String loginId;
	private String password;

	public String login() {
		return "/view/balance-report";
	}

	public String logout() {
		return "/login";
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
