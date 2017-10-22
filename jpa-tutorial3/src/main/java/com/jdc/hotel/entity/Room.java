package com.jdc.hotel.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;

@Entity
@SuppressWarnings("serial")
public class Room implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	private String roomNumber;

	@ElementCollection
	@CollectionTable(name = "Facilities", joinColumns = @JoinColumn(name = "room"))
	private List<String> facilities;

	private Security security;

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public List<String> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<String> facilities) {
		this.facilities = facilities;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

}