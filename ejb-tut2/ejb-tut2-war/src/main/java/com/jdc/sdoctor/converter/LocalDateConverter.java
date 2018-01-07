package com.jdc.sdoctor.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("LocalDateConverter")
public class LocalDateConverter implements Converter {

	private static final String format = "yyyy-MM-dd";

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String str) {
		if (null != str && !str.isEmpty()) {
			return LocalDate.parse(str, DateTimeFormatter.ofPattern(format));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (null != value && value instanceof LocalDate) {
			LocalDate date = (LocalDate) value;
			return date.format(DateTimeFormatter.ofPattern(format));
		}
		return null;
	}

}
