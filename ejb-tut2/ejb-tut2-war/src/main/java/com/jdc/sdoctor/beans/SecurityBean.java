package com.jdc.sdoctor.beans;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.jdc.sdoctor.model.SecurityModel;
import com.jdc.sdoctor.utils.MessageHandler;
import com.jdc.sdoctor.utils.SmartDoctorException;

@Model
@MessageHandler
public class SecurityBean {

	private String name;
	private String loginId;
	private String password;

	@EJB
	private SecurityModel model;

	public String login() {

		try {

			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			req.login(loginId, password);

		} catch (Exception e) {
			throw new SmartDoctorException("SMDE_0001");
		}

		return "/member/profile?faces-redirect=true";
	}

	public String signUp() {
		model.signUp(name, loginId, password);
		return login();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
