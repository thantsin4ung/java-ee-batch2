package com.jdc.askmequick.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String title;
	private String body;
	private User owner;
	private Category category;
	private List<String> tags;

	public Post() {
		owner = new User();
		tags = new ArrayList<>();
	}

	private Security security;

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
