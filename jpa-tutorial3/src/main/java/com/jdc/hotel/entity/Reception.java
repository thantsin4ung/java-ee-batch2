package com.jdc.hotel.entity;

import javax.persistence.Entity;

@Entity
@SuppressWarnings("serial")
public class Reception extends Account {

	private double otFees;

	public double getOtFees() {
		return otFees;
	}

	public void setOtFees(double otFees) {
		this.otFees = otFees;
	}

}
