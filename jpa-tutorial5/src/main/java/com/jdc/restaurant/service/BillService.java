package com.jdc.restaurant.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import com.jdc.restaurant.entity.Bill;
import com.jdc.restaurant.entity.Bill.Status;
import com.jdc.restaurant.entity.Table;

public class BillService {

	private EntityManager em;

	public BillService(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(Bill b) {
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
	}

	public void update(Bill b) {
		em.getTransaction().begin();
		em.merge(b);
		em.getTransaction().commit();
	}

	public void delete(Bill b) {
		b.getSecurity().setDelFlag(true);
		update(b);
	}

	public Bill findById(long id) {
		return null;
	}

	public List<Bill> find(LocalDate date) {
		return null;
	}

	public List<Bill> find(LocalDate date, boolean delFlag) {
		return null;
	}

	public List<Bill> find(Status status) {
		return null;
	}

	public List<Bill> find(Table table) {
		return null;
	}

	public List<Bill> find(LocalDate df, LocalDate dt, Status status, boolean delFlag) {
		return null;
	}

}
