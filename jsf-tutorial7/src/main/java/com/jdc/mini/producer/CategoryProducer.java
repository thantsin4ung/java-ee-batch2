package com.jdc.mini.producer;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.mini.entity.Balance.Type;
import com.jdc.mini.entity.Category;
import com.jdc.mini.service.CategoryService;

@ApplicationScoped
public class CategoryProducer {

	private List<Category> list;

	@Inject
	private CategoryService service;

	@PostConstruct
	private void postConstruct() {
		load(null);
	}

	public void load(@Observes Category category) {
		list = service.getAll();
	}

	@Named
	@Produces
	public List<Category> getCategories() {
		return list.stream().filter(a -> !a.getSecurity().isDelFlag()).collect(Collectors.toList());
	}

	@Named
	@Produces
	public List<Category> getAllCategories() {
		return list;
	}

	@Named
	@Produces
	public List<Category> getIncomeCategories() {
		return find(Type.Income);
	}

	@Named
	@Produces
	public List<Category> getExpenseCategories() {
		return find(Type.Expense);
	}

	public List<Category> find(Type type) {
		return getCategories().stream().filter(a -> a.getType() == type).collect(Collectors.toList());
	}
}
