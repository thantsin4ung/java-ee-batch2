package com.jdc.mini.beans;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.mini.entity.Balance;
import com.jdc.mini.entity.Balance.Type;
import com.jdc.mini.entity.BalanceItem;
import com.jdc.mini.entity.Category;
import com.jdc.mini.entity.Reasons;
import com.jdc.mini.producer.CategoryProducer;
import com.jdc.mini.producer.ReasonProducer;
import com.jdc.mini.service.BalanceService;

@Named
@ViewScoped
public class BalanceEditBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Balance balance;
	private List<Reasons> reasons;

	@Inject
	private ReasonProducer reasonsProducer;
	@Inject
	private BalanceService service;

	@Inject
	private CategoryProducer categoryProducer;

	@PostConstruct
	private void init() {
		String str = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

		if (null != str && str.isEmpty()) {
			long id = Long.parseLong(str);
			balance = service.findById(id);
		}

		if (null == balance) {
			balance = new Balance();
			String type = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("type");
			balance.setType(Type.valueOf(type));
			addItem();
		}
	}

	public void addItem() {

		try {
			BalanceItem item = new BalanceItem();
			List<Category> categories = categoryProducer.find(balance.getType());
			item.setCategory(categories.get(0));
			balance.addItem(item);
			changeCategory(item);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(null, "There is no Category for balance registration.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	public void selectReason(BalanceItem item) {
		try {
			item.setReason(reasons.get(item.getReasonId() - 1).getReason());
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(null, "There is no reason with this number.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void changeCategory(BalanceItem item) {
		Category category = item.getCategory();
		reasons = reasonsProducer.getReasons().stream().filter(a -> a.getCategory().equals(category))
				.collect(Collectors.toList());
	}

	public void removeItem(BalanceItem item) {
		if (balance.getItems().size() > 1) {
			balance.getItems().remove(item);
		} else {
			FacesMessage message = new FacesMessage(null, "You can not remove last item.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public String save() {
		service.save(balance);
		return "/view/member/balance-report?faces-redirect=true";
	}

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	public List<Reasons> getReasons() {
		return reasons;
	}

	public void setReasons(List<Reasons> reasons) {
		this.reasons = reasons;
	}

}
