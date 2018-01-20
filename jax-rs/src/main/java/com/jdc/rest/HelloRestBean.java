package com.jdc.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jdc.rest.model.Member;

@Path("hello")
public class HelloRestBean {

	@GET
	public String sayHello() {
		return "Hello REST Application";
	}

	@GET
	@Path("member")
	@Produces(MediaType.APPLICATION_JSON)
	public Member getMember() {
		Member member = new Member();
		member.setName("Aung Aung");
		member.setPhone("0987766778");
		member.setEmail("aung@gmail.com");
		return member;
	}
}
