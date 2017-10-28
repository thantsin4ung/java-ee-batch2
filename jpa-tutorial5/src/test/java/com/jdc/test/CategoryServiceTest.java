package com.jdc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jdc.restaurant.entity.Category;
import com.jdc.restaurant.service.CategoryService;

public class CategoryServiceTest {

	private static EntityManagerFactory EMF;
	private EntityManager em;
	private CategoryService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		EMF = Persistence.createEntityManagerFactory("jpa-tutorial5");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		EMF.close();
	}

	@Before
	public void setUp() throws Exception {
		em = EMF.createEntityManager();
		service = new CategoryService(em);
	}

	@After
	public void tearDown() throws Exception {
		em.close();
	}

	@Test
	public void test1() {
		Category c = new Category();
		c.setName("BBQ");

		service.create(c);

		assertEquals(1, c.getId());
	}

	@Test
	public void test2() {
		Category c = service.findById(1L);
		assertNotNull(c);
		assertEquals("BBQ", c.getName());
		assertFalse(c.getSecurity().isDelFlag());

		assertNull(service.findById(2L));
	}

	@Test
	public void test3() {
		List<Category> list = service.getAll();
		assertEquals(1, list.size());
	}

	@Test
	public void test4() {
		Category c = service.findById(1L);
		c.setName("Drinks");

		service.update(c);

		Category c1 = service.findById(1L);
		assertEquals("Drinks", c1.getName());
	}

}
