package com.jdc.sememtic.producer;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.sememtic.entity.Category;
import com.jdc.sememtic.service.CategoryService;

@ApplicationScoped
public class CategoryProducer {

	@Named
	@Produces
	private List<Category> categories;

	@Inject
	private CategoryService service;

	@PostConstruct
	private void init() {
		categories = service.getAll();
	}

}
