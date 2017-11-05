package com.jdc.student;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class EditStudentModel {

	private Student student;

	@Inject
	private StudentRepository repo;

	@PostConstruct
	private void init() {
		student = new Student();
	}

	public String addStudent() {
		repo.add(student);
		return "/index?faces-redirect=true";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
