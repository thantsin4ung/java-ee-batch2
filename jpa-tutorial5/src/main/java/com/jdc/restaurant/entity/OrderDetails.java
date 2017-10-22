package com.jdc.restaurant.entity;

import java.io.Serializable;

public class OrderDetails implements Serializable {

	public OrderDetails() {
	}

	private long id;

	private int quantity;

	private double unitPrice;

	private Item item;

	private Order order;

	private Status status;

	private Security security;

	public enum Status {
		Ordered, Cancel, StartCook, Cooked, Finished
	}

}