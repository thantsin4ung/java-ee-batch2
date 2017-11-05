package com.jdc.student;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.jdc.student.Student.Course;
import com.jdc.student.Student.Gender;

public class CommonProducer {

	@Named
	@Produces
	public Gender[] getGenders() {
		return Gender.values();
	}

	@Named
	@Produces
	public Course[] getCourses() {
		return Course.values();
	}
}
