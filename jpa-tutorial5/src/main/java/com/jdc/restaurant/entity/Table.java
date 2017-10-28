package com.jdc.restaurant.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@SuppressWarnings("serial")
@NamedQueries({ @NamedQuery(name = "Table.getAll", query = "select t from Table t") })
@javax.persistence.Table(name = "Tables")
public class Table implements Serializable {

	public Table() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	private String tableNumber;

	private int chairs;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}

	public int getChairs() {
		return chairs;
	}

	public void setChairs(int chairs) {
		this.chairs = chairs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + chairs;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((tableNumber == null) ? 0 : tableNumber.hashCode());
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
		Table other = (Table) obj;
		if (chairs != other.chairs)
			return false;
		if (id != other.id)
			return false;
		if (tableNumber == null) {
			if (other.tableNumber != null)
				return false;
		} else if (!tableNumber.equals(other.tableNumber))
			return false;
		return true;
	}

}