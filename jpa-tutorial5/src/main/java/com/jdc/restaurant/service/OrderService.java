package com.jdc.restaurant.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import com.jdc.restaurant.entity.Order;
import com.jdc.restaurant.entity.OrderDetails;
import com.jdc.restaurant.entity.OrderDetails.Status;
import com.jdc.restaurant.entity.Table;

public class OrderService {

	private EntityManager em;

	public OrderService(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(Order order) {

	}

	public void update(Order order) {

	}

	public void delete(Order order) {
		order.getSecurity().setDelFlag(true);
		update(order);
	}

	public Order findById(long id) {
		return em.find(Order.class, id);
	}

	public List<Order> find(Table table) {
		return null;
	}

	public List<Order> find(LocalDateTime timeFrom) {
		return null;
	}

	public List<OrderDetails> findDetails(LocalDateTime timeFrom) {
		return null;
	}

	public List<OrderDetails> findDetails(Status status) {
		return null;
	}

	public List<OrderDetails> findDetails(Table table) {
		return null;
	}

	public List<OrderDetails> findDetails(Table table, Status status, LocalDateTime timeFrom) {
		return null;
	}

}
