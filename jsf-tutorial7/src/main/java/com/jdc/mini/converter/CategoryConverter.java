package com.jdc.mini.converter;

import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import com.jdc.mini.entity.Category;
import com.jdc.mini.service.CategoryService;

@Model
public class CategoryConverter implements Converter {

	@Inject
	private CategoryService service;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {

		if (null != value && !value.isEmpty()) {
			long id = Long.parseLong(value);
			return service.find(id);
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

		if (null != value) {
			Category category = (Category) value;
			return String.valueOf(category.getId());
		}
		return null;
	}

}
