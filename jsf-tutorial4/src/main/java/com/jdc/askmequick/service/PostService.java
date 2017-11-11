package com.jdc.askmequick.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import com.jdc.askmequick.entity.Post;

@ApplicationScoped
public class PostService {

	private List<Post> posts;

	@PostConstruct
	private void init() {
		posts = new ArrayList<>();
	}

	public void add(Post post) {
		posts.add(post);
	}

	public List<Post> getAll() {
		return posts;
	}

}
