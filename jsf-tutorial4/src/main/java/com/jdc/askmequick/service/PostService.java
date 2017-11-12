package com.jdc.askmequick.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.askmequick.entity.Post;

@Stateless
@LocalBean
public class PostService {

	@PersistenceContext
	private EntityManager em;

	public void add(Post post) {
		em.persist(post);
	}

	public List<Post> getAll() {
		return em.createNamedQuery("Post.getAll", Post.class).getResultList();
	}

}
