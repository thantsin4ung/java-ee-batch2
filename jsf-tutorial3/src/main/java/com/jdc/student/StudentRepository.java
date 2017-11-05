package com.jdc.student;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StudentRepository {

	private List<Student> students;

	@PostConstruct
	private void init() {
		students = new ArrayList<>();
	}

	public void add(Student student) {
		students.add(student);
	}

	public List<Student> getAll() {
		return students;
	}

}
