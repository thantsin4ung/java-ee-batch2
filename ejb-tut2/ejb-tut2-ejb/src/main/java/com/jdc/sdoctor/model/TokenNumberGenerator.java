package com.jdc.sdoctor.model;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

@LocalBean
@Singleton
public class TokenNumberGenerator {

	private int token;

	@Schedule(hour = "0")
	public void init() {
		token = 0;
	}

	public int getToken() {
		return ++token;
	}

}
