package com.jdc.sdoctor.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.Part;

import com.jdc.sdoctor.entity.Medicine;
import com.jdc.sdoctor.entity.Medicine.Type;

@LocalBean
@Stateless
public class MedicineModel {

	@PersistenceContext
	private EntityManager em;

	public List<Medicine> search(Type type, String company, String name) {
		StringBuffer sb = new StringBuffer("select m from Medicine m where 1 = 1 ");
		Map<String, Object> params = new HashMap<>();

		if (null != type) {
			sb.append("and m.type = :type ");
			params.put("type", type);
		}

		if (null != company && !company.isEmpty()) {
			sb.append("and upper(m.company) like upper(:company) ");
			params.put("company", company.concat("%"));
		}

		if (null != name && !name.isEmpty()) {
			sb.append("and upper(m.name) like upper(:name) ");
			params.put("name", name.concat("%"));
		}

		TypedQuery<Medicine> q = em.createQuery(sb.toString(), Medicine.class);

		for (String key : params.keySet()) {
			q.setParameter(key, params.get(key));
		}

		return q.getResultList();
	}

	@Asynchronous
	public void uploadFile(Part file) {
		// TODO Auto-generated method stub

	}

}
