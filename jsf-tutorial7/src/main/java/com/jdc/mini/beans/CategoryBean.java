package com.jdc.mini.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.mini.entity.Category;
import com.jdc.mini.service.CategoryService;

@Named
@ViewScoped
public class CategoryBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Category data;
	private boolean showPopup;

	@Inject
	private CategoryService service;

	@PostConstruct
	private void postConstruct() {
		data = new Category();
	}

	public String save() {
		service.save(data);
		return "/view/admin/categories?faces-redirect=true";
	}

	public void addNew() {
		data = new Category();
		showPopup = true;
	}

	public void edit(Category c) {
		data = c;
		showPopup = true;
	}

	public String delete(Category c) {
		c.getSecurity().setDelFlag(true);
		service.save(c);
		return "/view/categories?faces-redirect=true";
	}

	public Category getData() {
		return data;
	}

	public void setData(Category data) {
		this.data = data;
	}

	public boolean isShowPopup() {
		return showPopup;
	}

	public void setShowPopup(boolean showPopup) {
		this.showPopup = showPopup;
	}

}
