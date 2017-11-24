package com.jdc.mini.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.mini.entity.Balance.Type;
import com.jdc.mini.producer.CategoryProducer;
import com.jdc.mini.entity.Category;
import com.jdc.mini.entity.Reasons;
import com.jdc.mini.service.ReasonService;

@Named
@ViewScoped
public class ReasonBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Reasons data;
	private boolean showPopup;
	private Type type;
	private List<Category> categories;

	@Inject
	private CategoryProducer categoryResources;

	@Inject
	private ReasonService service;

	@PostConstruct
	private void postConstruct() {
		data = new Reasons();
		categories = categoryResources.find(Type.Income);
	}

	public String save() {
		service.save(data);
		return "/view/admin/reasons?faces-redirect=true";
	}

	public void changeType() {
		categories = categoryResources.find(type);
	}

	public void addNew() {
		data = new Reasons();
		categories = categoryResources.find(Type.Income);
		showPopup = true;
	}

	public void edit(Reasons c) {
		data = c;
		showPopup = true;
	}

	public String delete(Reasons c) {
		c.getSecurity().setDelFlag(true);
		service.save(c);
		return "/view/reasons?faces-redirect=true";
	}

	public Reasons getData() {
		return data;
	}

	public void setData(Reasons data) {
		this.data = data;
	}

	public boolean isShowPopup() {
		return showPopup;
	}

	public void setShowPopup(boolean showPopup) {
		this.showPopup = showPopup;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
