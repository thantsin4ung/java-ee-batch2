package com.jdc.sdoctor.converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("LocalTimeConverter")
public class LocalTimeConverter implements Converter {

	private static final String format = "HH:mm";

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String str) {
		if (null != str && !str.isEmpty()) {
			return LocalTime.parse(str, DateTimeFormatter.ofPattern(format));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (null != value && value instanceof LocalTime) {
			LocalTime date = (LocalTime) value;
			return date.format(DateTimeFormatter.ofPattern(format));
		}
		return null;
	}

}
