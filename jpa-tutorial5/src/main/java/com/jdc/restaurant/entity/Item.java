package com.jdc.restaurant.entity;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {

	public Item() {
	}

	private long id;

	private String name;

	private String image;

	private Category category;

	private List<ItemPrice> prices;

}