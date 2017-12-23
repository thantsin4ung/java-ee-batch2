package com.jdc.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

@Stateful
public class StatefulContainer implements StatefulContainerLocal, Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> list;

	@PostConstruct
	private void init() {
		list = new ArrayList<>();
	}

	@Override
	public void add(String message) {
		list.add(message);
	}

	@Override
	public List<String> getAll() {
		return list;
	}

}
