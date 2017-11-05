package com.jdc.jsf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;

@Model
public class StudentModel {

	private List<Student> list;

	@PostConstruct
	private void init() {
		list = new ArrayList<>();
		list.add(new Student("Aung Aung", "09876654", "aung@gmail.com"));
		list.add(new Student("Maung Maung", "09876655", "maung@gmail.com"));
		list.add(new Student("Thidar Aung", "09876656", "thidar@gmail.com"));
		list.add(new Student("Nilar Aung", "09876657", "nilar@gmail.com"));
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

}
