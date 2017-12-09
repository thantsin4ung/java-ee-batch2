package com.jdc.cdi.decorate;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

public class CoffeeBean {

	@Produces
	@Named("myCoffee")
	private Coffee coffee;

	@Inject
	private CoffeeDripper dripper;

	@Inject
	private void postConstruct() {
		coffee = dripper.getCoffee();
	}
}
