package com.jdc.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import com.jdc.client.Member;
import com.jdc.client.MemberClient;

public class MemberResourceTest {
	
	private MemberClient client;

	@Before
	public void setUp() throws Exception {
		client = new MemberClient();
	}

	@Test
	public void test1() {
		List<Member> list = client.getAll();
		assertNotNull(list);
		
		assertEquals(5, list.size());
	}
	
	@Test
	public void test2() {
		Member member = client.findById(1);
		assertNotNull(member);
		
		assertEquals("Aung Aung", member.getName());
		assertEquals("0987667888", member.getPhone());
		assertEquals("aung@gmail.com", member.getEmail());
		
		assertNull(client.findById(6));
	}
	
	@Test
	public void test3() {
		List<Member> list = client.findByNameLike("A");
		assertNotNull(list);
		assertEquals(1, list.size());

		List<Member> list2 = client.findByNameLike("Ak");
		assertNotNull(list2);
		assertEquals(0, list2.size());
	}
	
	@Test
	public void test4() {
		List<Member> list = client.findByPhone("0987667888");
		assertNotNull(list);
		assertEquals(1, list.size());

		List<Member> list2 = client.findByPhone("0987667887");
		assertNotNull(list2);
		assertEquals(0, list2.size());
	}
	
	@Test
	public void test5() {
		Member m = new Member();
		m.setName("Kyaw Kyaw");
		m.setEmail("kyaw@gmail.com");
		m.setPhone("097867555");
		
		m = client.create(m);
		
		assertNotNull(m);
		
		assertNotEquals(0, m.getId());
		
		List<Member> list = client.getAll();
		assertEquals(6, list.size());
	}
	
	@Test
	public void test6() {
		Member m = client.getAll().get(5);
		m.setName("Kyaw Oo");
		
		int status = client.update(m);
		assertEquals(HttpStatus.SC_ACCEPTED, status);
		
		m = client.findById(m.getId());
		
		assertEquals("Kyaw Oo", m.getName());
	}
	
	@Test
	public void test7() {
		Member m = client.getAll().get(5);
		int status = client.delete(m.getId());
		assertEquals(HttpStatus.SC_OK, status);
	}

}
