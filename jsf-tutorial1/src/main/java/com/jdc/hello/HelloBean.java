package com.jdc.hello;

import java.time.LocalDate;

import javax.enterprise.inject.Model;

@Model
public class HelloBean {

	private String name = "Aung Aung";
	private int age = 20;
	private LocalDate date = LocalDate.of(1997, 1, 10);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
