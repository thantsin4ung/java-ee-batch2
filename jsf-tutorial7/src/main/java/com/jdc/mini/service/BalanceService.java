package com.jdc.mini.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jdc.mini.entity.Balance;
import com.jdc.mini.entity.Balance.Type;
import com.jdc.mini.entity.BalanceItem;
import com.jdc.mini.entity.Category;
import com.jdc.mini.entity.Member;

@LocalBean
@Stateless
public class BalanceService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private SessionContext ctx;

	public void save(Balance balance) {

		String loginId = ctx.getCallerPrincipal().getName();
		Member member = em.find(Member.class, loginId);
		balance.setMember(member);
		balance.getSecurity().setUpdateUser(loginId);
		if (balance.getId() == 0) {
			balance.getSecurity().setCreateUser(loginId);
			em.persist(balance);
		} else {
			em.merge(balance);
		}

	}

	public Balance findById(long id) {
		return em.find(Balance.class, id);
	}

	public List<BalanceItem> search(Type type, Category category, LocalDate dateFrom, LocalDate dateTo) {

		Map<String, Object> params = new HashMap<>();
		StringBuffer sb = new StringBuffer("select b from BalanceItem b where b.security.delFlag = false ");

		if (null != type) {
			sb.append("and b.parent.type = :type ");
			params.put("type", type);
		}

		if (null != category) {
			sb.append("and b.category = :category ");
			params.put("category", category);
		}

		if (null != dateFrom) {
			sb.append("and b.parent.refDate >= :dateFrom ");
			params.put("dateFrom", dateFrom);
		}

		if (null != dateTo) {
			sb.append("and b.parent.refDate <= :dateTo ");
			params.put("dateTo", dateTo);
		}

		sb.append(" order by b.parent.refDate");

		TypedQuery<BalanceItem> q = em.createQuery(sb.toString(), BalanceItem.class);

		for (String key : params.keySet()) {
			q.setParameter(key, params.get(key));
		}

		List<BalanceItem> result = q.getResultList();

		if (result.size() > 0) {
			int incomes = getTotalIncomes(result.get(0).getParent().getRefDate());
			int expenses = getTotalExpenses(result.get(0).getParent().getRefDate());

			int balance = incomes - expenses;

			for (BalanceItem b : result) {
				balance -= b.getExpense();
				balance += b.getIncome();

				b.setBalance(balance);
			}
		}

		return result;
	}

	private int getTotalExpenses(LocalDate dateFrom) {
		if (null != dateFrom) {
			TypedQuery<Long> q = em.createNamedQuery("BalanceItem.getTotalExpenses", Long.class);
			q.setParameter("dateTo", dateFrom);
			Long result = q.getSingleResult();
			return result == null ? 0 : result.intValue();
		}
		return 0;
	}

	private int getTotalIncomes(LocalDate dateFrom) {
		if (null != dateFrom) {
			TypedQuery<Long> q = em.createNamedQuery("BalanceItem.getTotalIncomes", Long.class);
			q.setParameter("dateTo", dateFrom);
			Long result = q.getSingleResult();
			return result == null ? 0 : result.intValue();
		}
		return 0;
	}

}
