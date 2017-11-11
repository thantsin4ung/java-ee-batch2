package com.jdc.askmequick.model.converter;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.askmequick.entity.Category;

@Model
public class CategoryConverter implements Converter {

	@Inject
	@Named
	private List<Category> categories;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {

		if (null != value && !value.isEmpty()) {
			long id = Long.valueOf(value);
			for (Category category : categories) {
				if (category.getId() == id) {
					return category;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (null != value) {
			Category c = (Category) value;
			return String.valueOf(c.getId());
		}
		return null;
	}

}
