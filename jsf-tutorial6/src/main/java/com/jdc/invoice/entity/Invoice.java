package com.jdc.invoice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.FetchType.EAGER;

@Entity
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private String customer;
	private LocalDateTime invoiceDate;
	@OneToMany(mappedBy = "invoice", cascade = { PERSIST, MERGE }, orphanRemoval = true, fetch = EAGER)
	private List<Item> items;

	@PrePersist
	private void prePersist() {
		invoiceDate = LocalDateTime.now();
	}

	public Invoice() {
		items = new ArrayList<>();
	}

	public void addItem(Item item) {
		item.setInvoice(this);
		items.add(item);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public LocalDateTime getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDateTime invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getItemCount() {
		return items.stream().mapToInt(a -> a.getQuantity()).sum();
	}

	public int getTotal() {
		return items.stream().mapToInt(a -> a.getTotal()).sum();
	}
}
