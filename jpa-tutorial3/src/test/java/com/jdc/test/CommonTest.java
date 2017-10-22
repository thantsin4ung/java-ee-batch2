package com.jdc.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class CommonTest {

	@Test
	public void test() {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("jpa-tutorial3");
		EMF.close();
	}

}
