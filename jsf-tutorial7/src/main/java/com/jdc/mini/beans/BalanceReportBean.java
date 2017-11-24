package com.jdc.mini.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.mini.entity.Balance.Type;
import com.jdc.mini.entity.BalanceItem;
import com.jdc.mini.entity.Category;
import com.jdc.mini.producer.CategoryProducer;
import com.jdc.mini.service.BalanceService;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class BalanceReportBean implements Serializable {

	private Type type;
	private Category category;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private List<BalanceItem> balances;

	private List<Category> categories;

	@Inject
	private CategoryProducer categoryProducer;

	@Inject
	private BalanceService service;

	@PostConstruct
	private void init() {
		dateFrom = LocalDate.now().withDayOfMonth(1);
		innerSearch();
	}

	public void innerSearch() {
		balances = service.search(type, category, dateFrom, dateTo);
	}

	public void changeType() {
		categories = categoryProducer.find(type);
	}

	public String search() {
		innerSearch();
		return null;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public List<BalanceItem> getBalances() {
		return balances;
	}

	public void setBalances(List<BalanceItem> balances) {
		this.balances = balances;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
