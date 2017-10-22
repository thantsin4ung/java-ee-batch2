package com.jdc.hotel.entity;

import static javax.persistence.InheritanceType.JOINED;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToOne;

@Entity
@SuppressWarnings("serial")
@Inheritance(strategy = JOINED)
public abstract class Account implements Serializable {

	@Id
	private String loginId;
	private String password;
	private String name;

	@OneToOne
	private Contact contact;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
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
