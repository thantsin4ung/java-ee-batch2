package com.jdc.restaurant.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jdc.restaurant.entity.Category;
import com.jdc.restaurant.entity.Item;
import com.jdc.restaurant.entity.Kitchen;

public class ItemService {

	private EntityManager em;

	public ItemService(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(Item item) {
		this.em.getTransaction().begin();
		this.em.persist(item);
		this.em.getTransaction().commit();
	}

	public void update(Item item) {
		this.em.getTransaction().begin();
		this.em.merge(item);
		this.em.getTransaction().commit();
	}

	public Item findById(long id) {
		return this.em.find(Item.class, id);
	}

	public List<Item> findByCategory(Category cat) {
		return this.findByCategoryAndKitchen(cat, null);
	}

	public List<Item> findByKitchen(Kitchen k) {
		return this.findByCategoryAndKitchen(null, k);
	}

	public List<Item> findByCategoryAndKitchen(Category c, Kitchen k) {

		StringBuffer sb = new StringBuffer("select i from Item i where i.security.delFlag = false ");
		Map<String, Object> params = new HashMap<>();

		if (null != c) {
			sb.append("and i.category = :category ");
			params.put("category", c);
		}

		if (k != null) {
			sb.append("and i.kitchen = :kitchen ");
			params.put("kitchen", k);
		}

		TypedQuery<Item> q = em.createQuery(sb.toString(), Item.class);

		for (String key : params.keySet()) {
			q.setParameter(key, params.get(key));
		}

		return q.getResultList();
	}
}
