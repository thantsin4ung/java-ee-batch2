package com.jdc.student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Model
public class LocalDateConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {

		if (value != null && !value.isEmpty()) {
			return LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-M-d"));
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (null != value) {
			LocalDate date = (LocalDate) value;
			return date.format(DateTimeFormatter.ofPattern("yyyy-M-d"));
		}
		return null;
	}

}
