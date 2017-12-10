package com.jdc.sememtic.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("dateTimeConverter")
public class DateTimeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		String pattern = "yyyy-MM-dd HH:mm";

		if (null != value) {
			LocalDateTime date = (LocalDateTime) value;
			return date.format(DateTimeFormatter.ofPattern(pattern));
		}
		return null;
	}

}
