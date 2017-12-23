package com.jdc.service.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class StatelessContainer implements StatelessContainerLocal {

	private List<String> list;

	@PostConstruct
	private void init() {
		list = new ArrayList<>();
	}

	@Override
	public void add(String message) {
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		list.add(message);
	}

	@Override
	public List<String> getMessages() {
		return list;
	}

}
