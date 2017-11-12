package com.jdc.askmequick.model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.askmequick.entity.Post;
import com.jdc.askmequick.service.PostService;

@Named
@RequestScoped
public class PostEditBean {

	private Post post;

	@Inject
	private PostService service;

	@PostConstruct
	private void init() {
		post = new Post();
	}

	public String save() {
		String loginId = post.getOwner().getName().replaceAll(" ", "").toLowerCase();
		post.getOwner().setLoginId(loginId);
		service.add(post);
		return "/home?faces-redirect=true";
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
