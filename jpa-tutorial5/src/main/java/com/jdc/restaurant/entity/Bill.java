package com.jdc.restaurant.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Bill implements Serializable {

	public Bill() {
	}

	private long id;

	private LocalDate refDate;

	private LocalDateTime checkInTime;

	private LocalDateTime checkOutTime;

	private double subTotal;

	private double tax;

	private double serviceCharge;

	private double total;

	private int customers;

	private Category category;

	public Table table;

	private Status status;

	private Security security;

	public enum Status {
		CheckIn, CheckOut, Cancel
	}

}