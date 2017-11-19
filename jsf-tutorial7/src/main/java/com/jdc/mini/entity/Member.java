package com.jdc.mini.entity;

import static javax.persistence.EnumType.STRING;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.jdc.mini.listener.CommonEntity;

@Entity
public class Member implements CommonEntity {

	private static final long serialVersionUID = 1L;

	@Id
	private String email;
	private String name;
	private String password;
	@Enumerated(STRING)
	private Role role;
	private Security security;

	public Member() {
		security = new Security();
	}

	public enum Role {
		Admin, Member
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

}
