package com.jdc.stm.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.OneToOne;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;

@Entity
@SuppressWarnings("serial")
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
	private String name;
	private String phone;

	@OneToOne(cascade = { PERSIST, MERGE })
	private Address address;

	private LocalDateTime creation;
	private LocalDateTime modification;

	@PrePersist
	private void prePersist() {
		creation = LocalDateTime.now();
		modification = LocalDateTime.now();
	}

	@PostPersist
	private void postPersist() {
		System.out.printf("%s is insert at %s%n", name,
				creation.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDateTime getCreation() {
		return creation;
	}

	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}

	public LocalDateTime getModification() {
		return modification;
	}

	public void setModification(LocalDateTime modification) {
		this.modification = modification;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
