package com.jdc.invoice.model;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.invoice.entity.Invoice;
import com.jdc.invoice.entity.Item;
import com.jdc.invoice.service.InvoiceService;

@Named
@ViewScoped
public class InvoiceBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Invoice invoice;

	@Inject
	private InvoiceService service;

	private String title;

	@PostConstruct
	private void postConstruct() {

		invoice = new Invoice();
		invoice.addItem(new Item());
		title = "Create Invoice";

		String str = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		String operation = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("ope");

		if (null != str && !str.isEmpty()) {
			int id = Integer.parseInt(str);
			invoice = service.findById(id);

			if (null != operation && operation.equals("edit")) {
				title = "Edit Invoice";
			} else {
				title = "Invoice Details";
			}
		}
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public String save() {
		service.save(invoice);
		return "/invoice-list?faces-redirect=true";
	}

	public void addItem() {
		invoice.addItem(new Item());
	}

	public void removeItem(Item item) {
		invoice.getItems().remove(item);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isEdit() {
		return !title.equals("Invoice Details");
	}

}
