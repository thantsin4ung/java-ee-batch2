package com.jdc.hotel.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("serial")
public class RoomReservationPK implements Serializable {

	private long reservationId;
	private long roomId;

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (reservationId ^ (reservationId >>> 32));
		result = prime * result + (int) (roomId ^ (roomId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoomReservationPK other = (RoomReservationPK) obj;
		if (reservationId != other.reservationId)
			return false;
		if (roomId != other.roomId)
			return false;
		return true;
	}

}
