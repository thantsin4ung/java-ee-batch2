package com.jdc.mini.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("localDateConverter")
public class LocalDateConverter implements Converter {

	private static final String PATTERN = "yyyy-MM-dd";

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {

		if (null != value && !value.isEmpty()) {
			LocalDate date = LocalDate.parse(value, DateTimeFormatter.ofPattern(PATTERN));
			return date;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

		if (null != value) {
			LocalDate date = (LocalDate) value;
			return date.format(DateTimeFormatter.ofPattern(PATTERN));
		}
		return null;
	}

}
