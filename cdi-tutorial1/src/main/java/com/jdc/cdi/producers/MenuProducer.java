package com.jdc.cdi.producers;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class MenuProducer {

	@Produces
	public List<String> getMenus() {
		return Arrays.asList("Hello", "CDI", "Java EE");
	}

	@Named
	@Produces
	public String getTitle() {
		return "CDI Tutorial";
	}

	@Named("version")
	@Produces
	public int getVersionNumber() {
		return 1;
	}
}
