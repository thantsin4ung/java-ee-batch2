package com.jdc.sememtic.converter;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.sememtic.entity.Category;
import com.jdc.sememtic.service.CategoryService;

@Named
@RequestScoped
public class CategoryConverter implements Converter {

	@Inject
	private CategoryService service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		try {
			if (null != value && !value.isEmpty()) {

				long id = Long.parseLong(value);
				return service.findById(id);
			}
		} catch (Exception e) {
			System.out.println("Select One Value");
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (null != value && value instanceof Category) {
			Category c = (Category) value;
			return String.valueOf(c.getId());
		}

		return null;
	}

}
