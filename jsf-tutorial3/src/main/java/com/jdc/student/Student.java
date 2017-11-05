package com.jdc.student;

import java.time.LocalDate;

public class Student {

	private static int count;

	private int id;
	private String name;
	private String phone;
	private LocalDate dob;
	private Gender gender;
	private Course course;

	public enum Gender {
		Male, Female
	}

	public enum Course {
		JavaSE, JavaEE, Spring
	}

	public Student() {
		id = ++count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
