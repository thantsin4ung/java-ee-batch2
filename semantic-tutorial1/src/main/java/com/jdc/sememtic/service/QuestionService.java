package com.jdc.sememtic.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jdc.sememtic.entity.Category;
import com.jdc.sememtic.entity.Question;

@LocalBean
@Stateless
public class QuestionService {

	@PersistenceContext
	private EntityManager em;

	public void save(Question question) {
		if (question.getId() > 0) {
			em.merge(question);
		} else {
			em.persist(question);
		}
	}

	public List<Question> search(Category category, String keyword) {
		StringBuffer sql = new StringBuffer("select q from Question q where 1 = 1 ");
		Map<String, Object> params = new HashMap<>();

		if (null != category) {
			sql.append("and q.category = :cat ");
			params.put("cat", category);
		}

		if (null != keyword && !keyword.trim().isEmpty()) {
			sql.append("and upper(q.title) like upper(:keyword) ");
			params.put("keyword", "%".concat(keyword).concat("%"));
		}

		sql.append("order by q.createTime desc");

		TypedQuery<Question> query = em.createQuery(sql.toString(), Question.class);

		for (String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}

		return query.getResultList();
	}
}
