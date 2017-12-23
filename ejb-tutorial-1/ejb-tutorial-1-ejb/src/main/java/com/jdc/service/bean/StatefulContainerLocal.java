package com.jdc.service.bean;

import java.util.List;

import javax.ejb.Local;

@Local
public interface StatefulContainerLocal {

	void add(String message);

	List<String> getAll();
}
