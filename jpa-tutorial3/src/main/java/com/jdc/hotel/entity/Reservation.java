package com.jdc.hotel.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

@Entity
@SuppressWarnings("serial")
public class Reservation implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	private LocalDate dateFrom;

	private LocalDate dateTo;

	private LocalDateTime reserveDate;

	@OneToMany(mappedBy = "reservation")
	private List<RoomReservation> rooms;
	
	private Security security;

	@ManyToOne
	@JoinColumn(name = "contact")
	private Customer contactPerson;

	public List<RoomReservation> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomReservation> rooms) {
		this.rooms = rooms;
	}

	public Customer getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(Customer contactPerson) {
		this.contactPerson = contactPerson;
	}

	@ElementCollection
	@MapKeyColumn(name = "targetDate")
	private Map<LocalDate, Integer> breakfasts;

	public Map<LocalDate, Integer> getBreakfasts() {
		return breakfasts;
	}

	public void setBreakfasts(Map<LocalDate, Integer> breakfasts) {
		this.breakfasts = breakfasts;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	public LocalDateTime getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(LocalDateTime reserveDate) {
		this.reserveDate = reserveDate;
	}

}