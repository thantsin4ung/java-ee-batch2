package com.jdc.mini.entity;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.jdc.mini.listener.CommonEntity;

@Entity
public class Balance implements CommonEntity {

	private static final long serialVersionUID = 1L;

	public enum Type {
		Income, Expense
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
	@NotNull(message = "Please enter Reference Date")
	private LocalDate refDate;
	private Type type;
	private Security security;
	@ManyToOne
	private Member member;

	@OneToMany(mappedBy = "parent", cascade = { PERSIST, MERGE }, orphanRemoval = true)
	private List<BalanceItem> items;

	public Balance() {
		security = new Security();
		items = new ArrayList<>();
	}

	public void addItem(BalanceItem item) {
		item.setParent(this);
		items.add(item);
	}

	public List<BalanceItem> getItems() {
		return items;
	}

	public void setItems(List<BalanceItem> items) {
		this.items = items;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDate refDate) {
		this.refDate = refDate;
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
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + ((refDate == null) ? 0 : refDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Balance other = (Balance) obj;
		if (id != other.id)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (refDate == null) {
			if (other.refDate != null)
				return false;
		} else if (!refDate.equals(other.refDate))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
