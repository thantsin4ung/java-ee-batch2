package com.jdc.restaurant.entity;

import java.io.Serializable;

public class Category implements Serializable {

	public Category() {
	}

	private long id;

	private String name;

	private String image;

	private Kitchen kitchen;

	private Security security;

}