package com.jdc.mini.beans;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.jdc.mini.entity.Member;
import com.jdc.mini.service.MemberService;
import com.jdc.mini.service.PasswordUtils;

@Model
public class LoginBean {

	private String loginId;
	private String password;
	private String newPassword;

	@Inject
	private MemberService service;

	public String login() {
		return login(loginId, password);
	}

	private String login(String email, String pass) {
		try {
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			req.login(email, pass);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(null, "Please check your email and password.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
		return "/view/member/balance-report?faces-redirect=true";
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public String changePassword() {

		Member member = service.findById(loginId);

		if (null == member) {
			FacesMessage message = new FacesMessage(null, "Please check your email address.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}

		if (!member.getPassword().equals(PasswordUtils.encript(password))) {
			FacesMessage message = new FacesMessage(null, "Please check your old password.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}

		member.setPassword(newPassword);

		service.changePassword(member);

		return login(member.getEmail(), newPassword);
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

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
