package com.jdc.restaurant.entity;

import java.io.Serializable;

public class Account implements Serializable {

	public Account() {
	}

	private String login;

	private String pass;

	private String name;

	private Role role;

	private Kitchen kitchen;

	public enum Role {
		Manager, Kitchen, Counter, Waiter, Admin
	}

}