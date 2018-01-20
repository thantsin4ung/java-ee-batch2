package com.jdc.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MemberClient {
	
	
	public List<Member> getAll() {
		
		Response resp = getTarget()
				.request(MediaType.APPLICATION_JSON).get();
		
		if(resp.getStatus() == 200) {
			return resp.readEntity(new GenericType<List<Member>>() {});
		}

		return null;
	}
	
	public Member findById(int id) {
		
		Response resp = getTarget()
				.path(String.valueOf(id))
				.request(MediaType.APPLICATION_JSON).get();
		
		if(resp.getStatus() == 200) {
			return resp.readEntity(Member.class);
		}
		
		return null;
	}
	
	public List<Member> findByNameLike(String name) {
		
		Response resp = getTarget()
				.path(name)
				.request(MediaType.APPLICATION_JSON).get();
		
		if(resp.getStatus() == 200) {
			return resp.readEntity(new GenericType<List<Member>>() {});
		}
		
		return null;
	}
	
	public List<Member> findByPhone(String phone) {
		
		Response resp = getTarget()
				.path("phone")
				.queryParam("phone", phone)
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		if(resp.getStatus() == 200) {
			return resp.readEntity(new GenericType<List<Member>>() {});
		}
		
		return null;
	}	

	public Member create(Member member) {
		
		Response resp = getTarget().request(MediaType.APPLICATION_JSON).post(Entity.json(member));
		
		if(201 == resp.getStatus()) {
			URI location =resp.getLocation();
			WebTarget resultTarget = ClientBuilder.newClient().target(location);
			Response resultResp = resultTarget.request(MediaType.APPLICATION_JSON).get();
			return resultResp.readEntity(Member.class);
		}
		
		return null;
	}
	
	public int update(Member member) {
		
		Response resp = getTarget().request(MediaType.APPLICATION_JSON).put(Entity.json(member));
		return resp.getStatus();
	
	}
	
	public int delete(int id) {
		return getTarget()
				.path(String.valueOf(id))
				.request().delete().getStatus();
	}
	
	private WebTarget getTarget() {
		String baseUrl = "http://localhost:8080/jax-rs/api/member/";
		
		return ClientBuilder.newClient().target(baseUrl);
	}


}
