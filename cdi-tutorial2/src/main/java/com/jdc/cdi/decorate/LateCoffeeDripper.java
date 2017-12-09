package com.jdc.cdi.decorate;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class LateCoffeeDripper implements CoffeeDripper {

	@Inject
	@Delegate
	private JavaCoffeeDripper dripper;

	@Override
	public Coffee getCoffee() {
		Coffee c = dripper.getCoffee();
		c.setMilk(2);
		c.setSugar(3);
		return c;
	}

}
