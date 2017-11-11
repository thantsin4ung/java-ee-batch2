package com.jdc.askmequick.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.jdc.askmequick.entity.Category;

@ApplicationScoped
public class CategoryService {

	@Named
	@Produces
	private List<Category> categories;

	@PostConstruct
	private void init() {
		categories = new ArrayList<>();
		Category c1 = new Category();
		c1.setId(1);
		c1.setName("Question");

		Category c2 = new Category();
		c2.setId(2);
		c2.setName("Rules");

		Category c3 = new Category();
		c3.setId(3);
		c3.setName("Suggestion");

		Category c4 = new Category();
		c4.setId(4);
		c4.setName("Advice");

		categories.add(c1);
		categories.add(c2);
		categories.add(c3);
		categories.add(c4);

	}
}
