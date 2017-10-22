package com.jdc.restaurant.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {

	public Order() {
	}

	private long id;

	private LocalDateTime odTime;

	private Bill bill;

	private Security security;

}