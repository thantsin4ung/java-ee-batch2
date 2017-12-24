package com.jdc.sdoctor.entity;

import static javax.persistence.EnumType.STRING;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.hibernate.validator.constraints.NotEmpty;

import com.jdc.sdoctor.utils.PasswordUtils;

@Entity
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum Role {
		Doctor, Staff, Patient
	}

	@Id
	@NotEmpty(message = "Please enter Login Id.")
	private String loginId;

	@NotEmpty(message = "Please enter Name.")
	private String name;
	@Enumerated(STRING)
	private Role role;

	@NotEmpty(message = "Please enter Password.")
	private String password;

	@PrePersist
	private void prePersist() {
		password = PasswordUtils.encript(password);
		if (null == role) {
			role = Role.Patient;
		}
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
