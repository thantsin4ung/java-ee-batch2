package com.jdc.mini.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("localDateTimeConverter")
public class LocalDateTimeConverter implements Converter {

	private static final String PATTERN = "yyyy-MM-dd HH:mm";

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {

		if (null != value && !value.isEmpty()) {
			LocalDateTime date = LocalDateTime.parse(value, DateTimeFormatter.ofPattern(PATTERN));
			return date;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

		if (null != value) {
			LocalDateTime date = (LocalDateTime) value;
			date.format(DateTimeFormatter.ofPattern(PATTERN));
		}
		return null;
	}

}
