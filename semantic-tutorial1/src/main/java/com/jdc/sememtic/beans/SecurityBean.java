package com.jdc.sememtic.beans;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.jdc.sememtic.entity.Member;
import com.jdc.sememtic.entity.Member.Role;
import com.jdc.sememtic.service.MemberService;
import com.jdc.sememtic.service.PasswordUtils;

@Model
public class SecurityBean {

	private String email;
	private String name;
	private String password;

	@Inject
	private MemberService service;

	@Inject
	private Event<String> loginEvent;

	public String login() {
		try {
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			request.login(email, password);

			// update login user
			loginEvent.fire(email);

		} catch (ServletException e) {
			e.printStackTrace();
			return null;
		}
		return "/index?faces-redirect=true";
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index?faces-redirect=true";
	}

	public String signup() {

		Member member = new Member();
		member.setName(name);
		member.setEmail(email);
		member.setPassword(PasswordUtils.encript(password));
		member.setRole(Role.Member);

		service.create(member);

		return login();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
