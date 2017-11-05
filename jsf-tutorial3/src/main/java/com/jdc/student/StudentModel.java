package com.jdc.student;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class StudentModel {

	private List<Student> list;

	@Inject
	private StudentRepository repo;

	@PostConstruct
	private void init() {
		list = repo.getAll();
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

}
