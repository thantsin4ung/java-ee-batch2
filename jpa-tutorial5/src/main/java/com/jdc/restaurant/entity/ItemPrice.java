package com.jdc.restaurant.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class ItemPrice implements Serializable {

	public ItemPrice() {
	}

	private long id;

	private LocalDate refDate;

	private double price;

	private Item item;

	private Security security;

}