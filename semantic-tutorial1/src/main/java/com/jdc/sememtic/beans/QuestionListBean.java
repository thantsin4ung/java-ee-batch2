package com.jdc.sememtic.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.jdc.sememtic.entity.Category;
import com.jdc.sememtic.entity.Question;
import com.jdc.sememtic.service.CategoryService;
import com.jdc.sememtic.service.QuestionService;

@Model
public class QuestionListBean {

	private Category category;
	private String keyword;

	private List<Question> list;

	@Inject
	private QuestionService service;
	@Inject
	private CategoryService catService;

	@PostConstruct
	private void postConstruct() {
		String catId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("catId");

		if (null != catId && !catId.isEmpty()) {
			long categoryId = Long.parseLong(catId);
			category = catService.findById(categoryId);
		}

		search();
	}

	public String search() {
		list = service.search(category, keyword);
		return "";
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<Question> getList() {
		return list;
	}

	public void setList(List<Question> list) {
		this.list = list;
	}

}
