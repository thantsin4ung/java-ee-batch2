package com.jdc.rest;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.jdc.rest.model.Member;
import com.jdc.rest.model.MemberModel;

@Path("member")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MemberResource {

	@EJB
	private MemberModel model;
	
	@Context
	private UriInfo uri;

	@GET
	public Response getAll() {
		List<Member> list = model.getAll();
		
		if(list.size() == 0) {
			Response.noContent().build();
		} 
		return Response.ok(list).build();
	}

	@GET
	@Path("{id : \\d+}")
	public Member findById(@PathParam("id") int id) {
		return model.findById(id);
	}

	@GET
	@Path("{name}")
	public Response findByNameLike(@PathParam("name") String name) {
		List<Member> list = model.findByNameLike(name);
		
		if(list.size() == 0) {
			Response.noContent().build();
		} 
		return Response.ok(list).build();
	}
	
	@GET
	@Path("phone")
	public List<Member> findByPhone(@QueryParam("phone") @DefaultValue("") String phone) {
		return model.findByPhone(phone);
	}
	
	@POST
	public Response create(Member member) {
		try {
			model.create(member);
			URI path = uri.getAbsolutePathBuilder().path(String.valueOf(member.getId())).build();
			return Response.created(path).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@PUT
	public Response update(Member member) {
		model.update(member);
		return Response.accepted(member).build();
	}
	
	@DELETE
	@Path("{id:\\d+}")
	public Response delete(@PathParam("id") int id) {
		model.delete(id);
		return Response.ok().build();
	}
}
