package com.jdc.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jdc.stm.entity.Address;
import com.jdc.stm.entity.Student;

public class StudentTest {

	private static EntityManagerFactory emf;
	private EntityManager em;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa-tutorial4");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@Before
	public void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@After
	public void after() {
		em.close();
	}

	@Test
	public void test1() {
		Student s = new Student();
		s.setName("Thidar");
		s.setPhone("1234");

		Address address = new Address();
		address.setAddress("San Yeik Nyein 6 Street");
		address.setTownship("Kamayut");

		s.setAddress(address);

		em.getTransaction().begin();

		em.persist(s);

		em.getTransaction().commit();

		assertEquals(1, s.getId());
	}

	@Test
	public void test2() {

		Student s = em.find(Student.class, 1L);
		assertEquals("Thidar", s.getName());
		assertEquals("1234", s.getPhone());

		Address address = s.getAddress();
		assertEquals(1L, address.getId());

		em.detach(s);

		em.getTransaction().begin();
		s.setPhone("5678");
		em.merge(s);
		em.getTransaction().commit();
	}

	@Test
	public void test3() {

		Student s = em.getReference(Student.class, 1L);

		assertEquals("Thidar", s.getName());
		assertEquals("5678", s.getPhone());
	}

	@Test
	public void test4() {

		Student s = em.find(Student.class, 1L);

		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();

		assertNull(em.find(Student.class, 1L));

	}

}
