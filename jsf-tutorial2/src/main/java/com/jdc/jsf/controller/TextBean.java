package com.jdc.jsf.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;

@Model
public class TextBean {

	private String label;
	private String text;
	private String param1;
	private String param2;

	@PostConstruct
	private void init() {
		label = "This is Label";
		text = "This is Text";
		param1 = "This is Param1";
		param2 = "This is Param2";
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

}
