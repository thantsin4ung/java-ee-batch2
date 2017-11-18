package com.jdc.invoice.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("localDateTimeConverter")
public class LocalDateTimeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if (null != value && !value.isEmpty()) {
			return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").parse(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

		if (null != value) {
			LocalDateTime obj = (LocalDateTime) value;
			return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(obj);
		}

		return null;
	}

}
