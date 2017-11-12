package com.jdc.askmequick.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Enumerated;
import static javax.persistence.EnumType.STRING;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String loginId;
	private String name;
	private String password;
	@Enumerated(STRING)
	private Role role;

	private Security security;

	public User() {
		security = new Security();
	}

	@PrePersist
	private void prePersist() {
		security.setCreation(LocalDateTime.now());
		security.setModification(LocalDateTime.now());
	}

	public enum Role {
		Admin, Member
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
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

}
