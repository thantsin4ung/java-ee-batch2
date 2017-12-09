package com.jdc.cdi.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.cdi.service.MemberService;

@Model
public class MenuBean {

	@Inject
	private List<String> menus;

	private String name;

	@Inject
	private MemberService service;

	public String save() {
		service.create(name);
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMenus() {
		return menus;
	}

	public void setMenus(List<String> menus) {
		this.menus = menus;
	}

}
