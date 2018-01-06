package com.jdc.sdoctor.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import com.jdc.sdoctor.entity.Medicine;
import com.jdc.sdoctor.entity.Medicine.Type;
import com.jdc.sdoctor.model.MedicineModel;
import com.jdc.sdoctor.utils.MessageHandler;

@Named
@ViewScoped
public class MedicineListBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Part file;

	private String name;
	private String company;
	private Type type;

	private List<Medicine> list;

	@EJB
	private MedicineModel model;

	@PostConstruct
	private void init() {
		search();
	}

	@MessageHandler
	public void search() {
		list = model.search(type, company, name);
	}

	@MessageHandler
	public String upload() {
		model.uploadFile(file);
		return "/doctor/medicines?faces-redirect=true";
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Medicine> getList() {
		return list;
	}

	public void setList(List<Medicine> list) {
		this.list = list;
	}

}
