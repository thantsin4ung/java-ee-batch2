package com.jdc.restaurant.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
@SuppressWarnings("serial")
@NamedQueries({ @NamedQuery(name = "Category.getAll", query = "select c from Category c") })
public class Category implements Serializable {

	public Category() {
		security = new Security();
	}

	@PrePersist
	private void prePersist() {
		security.setDelFlag(false);
		security.setCreation(LocalDateTime.now());
		security.setModification(LocalDateTime.now());
	}

	@PreUpdate
	private void preUpdate() {
		security.setModification(LocalDateTime.now());
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	private String name;

	private String image;

	private Security security;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((security == null) ? 0 : security.hashCode());
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
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (security == null) {
			if (other.security != null)
				return false;
		} else if (!security.equals(other.security))
			return false;
		return true;
	}

}