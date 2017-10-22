package com.jdc.hotel.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@SuppressWarnings("serial")
public class RoomReservation implements Serializable {

	public enum Status {
		Reserve, Cancel, CheckIn, CheckOut
	}
	
	public RoomReservation() {
		id = new RoomReservationPK();
	}

	@EmbeddedId
	private RoomReservationPK id;
	private Status status;

	@ManyToOne
	@JoinColumn(name = "roomId", insertable = false, updatable = false)
	private Room room;
	@ManyToOne
	@JoinColumn(name = "reservationId", insertable = false, updatable = false)
	private Reservation reservation;

	public RoomReservationPK getId() {
		return id;
	}

	public void setId(RoomReservationPK id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
		this.id.setRoomId(room.getId());
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
		this.id.setReservationId(reservation.getId());
	}

}
