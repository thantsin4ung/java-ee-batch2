package com.jdc.invoice.model;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.invoice.entity.Invoice;
import com.jdc.invoice.service.InvoiceService;

@Model
public class InvoiceListBean {

	private String customer;
	private LocalDate dateFrom;
	private LocalDate dateTo;

	private List<Invoice> list;

	@Inject
	private InvoiceService service;

	@PostConstruct
	private void postConstruct() {
		innerSearch();
	}

	public String search() {
		innerSearch();
		return "";
	}

	public String delete(int id) {
		service.delete(id);
		return "/invoice-list?faces-redirect=true";
	}

	private void innerSearch() {
		list = service.search(customer, dateFrom, dateTo);
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
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

	public List<Invoice> getList() {
		return list;
	}

	public void setList(List<Invoice> list) {
		this.list = list;
	}

}
