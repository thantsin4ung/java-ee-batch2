package com.jdc.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jdc.restaurant.RestaurantException;
import com.jdc.restaurant.entity.Account;
import com.jdc.restaurant.entity.Account.Role;
import com.jdc.restaurant.service.AccountService;

public class AccountServiceTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private AccountService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa-tutorial5");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@Before
	public void setUp() throws Exception {
		em = emf.createEntityManager();
		service = new AccountService(em);
	}

	@After
	public void after() throws Exception {
		em.close();
	}

	@Test
	public void test1() {
		Account ac = new Account();
		ac.setLogin("Aung");
		ac.setName("Aung Aung");
		ac.setPass("Pass");
		ac.setRole(Role.Admin);

		service.createAccount(ac);

		Assert.assertNotNull(service.login(ac.getLogin(), ac.getPass()));
	}

	@Test(expected = RestaurantException.class)
	public void test2() {
		// TODO Login Not Same Login ID
	}

	@Test(expected = RestaurantException.class)
	public void test3() {
		// TODO Login Not Same Password
	}

	@Test
	public void test4() {
		// TODO Find By Role (Found Test Case)

		// TODO Find By Role (Not Found Test Case)
	}

	@Test
	public void test5() {
		// TODO Update Consider about Before update and after update

	}
}
