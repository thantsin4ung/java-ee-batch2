package com.jdc.client;

import java.net.URI;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MemberClient {

	public Member create(Member member) {
		
		WebTarget target = ClientBuilder.newClient().target("http://localhost:8080/jax-rs/api/member");
		Response resp = target.request(MediaType.APPLICATION_JSON).post(Entity.json(member));
		
		if(201 == resp.getStatus()) {
			URI location =resp.getLocation();
			WebTarget resultTarget = ClientBuilder.newClient().target(location);
			Response resultResp = resultTarget.request(MediaType.APPLICATION_JSON).get();
			return resultResp.readEntity(Member.class);
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		Member member = new Member();
		member.setName("Kyaw Htoo");
		member.setPhone("0987667888");
		member.setEmail("kyaw@gmail.com");
		
		MemberClient client = new MemberClient();
		Member result = client.create(member);
		System.out.println(result.getId());
	}
}
