package com.jdc.invoice.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jdc.invoice.entity.Invoice;

@Stateless
@LocalBean
public class InvoiceService {

	@PersistenceContext
	private EntityManager em;

	public Invoice findById(int id) {
		return em.find(Invoice.class, id);
	}

	public void save(Invoice invoice) {
		if (invoice.getId() > 0) {
			em.merge(invoice);
		} else {
			em.persist(invoice);
		}
	}

	public void delete(int id) {
		em.remove(findById(id));
	}

	public List<Invoice> search(String customer, LocalDate dateFrom, LocalDate dateTo) {

		StringBuffer sb = new StringBuffer("select i from Invoice i where 1 = 1 ");
		Map<String, Object> params = new HashMap<>();

		if (null != customer && !customer.isEmpty()) {
			sb.append("and upper(i.customer) like upper(:customer) ");
			params.put("customer", customer.concat("%"));
		}

		if (null != dateFrom) {
			sb.append("and i.invoiceDate >= :dateFrom ");
			params.put("dateFrom", dateFrom.atStartOfDay());
		}

		if (null != dateTo) {
			sb.append("and i.invoiceDate < :dateTo ");
			params.put("dateTo", dateTo.atStartOfDay().plusDays(1));
		}

		TypedQuery<Invoice> query = em.createQuery(sb.toString(), Invoice.class);

		for (String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}

		return query.getResultList();
	}

}
