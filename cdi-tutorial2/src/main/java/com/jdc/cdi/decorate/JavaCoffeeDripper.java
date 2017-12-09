package com.jdc.cdi.decorate;

public class JavaCoffeeDripper implements CoffeeDripper {

	@Override
	public Coffee getCoffee() {
		Coffee c = new Coffee();
		c.setCoffeeName("Java Coffee");
		return c;
	}

}
