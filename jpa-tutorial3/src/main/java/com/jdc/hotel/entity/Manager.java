package com.jdc.hotel.entity;

import javax.persistence.Entity;

@Entity
@SuppressWarnings("serial")
public class Manager extends Account {

	private double bonus;

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}
