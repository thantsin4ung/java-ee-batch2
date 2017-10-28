package com.jdc.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
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
import com.jdc.restaurant.entity.Item;
import com.jdc.restaurant.entity.ItemPrice;
import com.jdc.restaurant.entity.Kitchen;
import com.jdc.restaurant.service.ItemService;

public class ItemServiceTest {

	private static EntityManagerFactory EMF;
	private EntityManager em;
	private ItemService service;

	private static Category c1;
	private static Category c2;
	private static Kitchen k1;
	private static Kitchen k2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		EMF = Persistence.createEntityManagerFactory("jpa-tutorial5");

		EntityManager em = EMF.createEntityManager();

		em.getTransaction().begin();

		// create 2 category
		c1 = new Category();
		c1.setName("BBQ");
		em.persist(c1);

		c2 = new Category();
		c2.setName("Drinks");
		em.persist(c2);

		// create 2 kitchen
		k1 = new Kitchen();
		k1.setName("BBQ Counter");
		em.persist(k1);

		k2 = new Kitchen();
		k2.setName("Drink Bar");
		em.persist(k2);

		Item orangeJuce = new Item();
		orangeJuce.setCategory(c2);
		orangeJuce.setKitchen(k2);

		orangeJuce.setName("Orange Juce");

		ItemPrice p = new ItemPrice();
		p.setPrice(1200);
		p.setRefDate(LocalDate.now());

		orangeJuce.addItemPrice(p);

		em.persist(orangeJuce);

		em.getTransaction().commit();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		EMF.close();
	}

	@Before
	public void setUp() throws Exception {
		em = EMF.createEntityManager();
		service = new ItemService(em);
	}

	@After
	public void tearDown() throws Exception {
		em.close();
	}

	@Test
	public void test1() {
		List<Item> list1 = service.findByCategory(null);
		assertEquals(1, list1.size());

		List<Item> list2 = service.findByCategory(c1);
		assertEquals(0, list2.size());

		List<Item> list3 = service.findByCategory(c2);
		assertEquals(1, list3.size());
	}

	@Test
	public void test2() {
		List<Item> list1 = service.findByKitchen(null);
		assertEquals(1, list1.size());

		List<Item> list2 = service.findByKitchen(k1);
		assertEquals(0, list2.size());

		List<Item> list3 = service.findByKitchen(k2);
		assertEquals(1, list3.size());
	}

	@Test
	public void test3() {
		List<Item> list1 = service.findByCategoryAndKitchen(c2, k2);
		assertEquals(1, list1.size());

		List<Item> list2 = service.findByCategoryAndKitchen(c1, k2);
		assertEquals(0, list2.size());

		List<Item> list3 = service.findByCategoryAndKitchen(c2, k1);
		assertEquals(0, list3.size());
	}

}
