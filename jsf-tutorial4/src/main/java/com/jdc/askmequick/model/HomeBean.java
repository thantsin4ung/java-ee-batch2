package com.jdc.askmequick.model;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.askmequick.entity.Post;
import com.jdc.askmequick.service.PostService;

@Named
@RequestScoped
public class HomeBean {

	private List<Post> posts;

	@Inject
	private PostService service;

	@PostConstruct
	private void init() {
		posts = service.getAll();
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
