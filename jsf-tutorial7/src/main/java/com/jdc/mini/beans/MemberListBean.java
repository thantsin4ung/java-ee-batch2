package com.jdc.mini.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.mini.entity.Member;
import com.jdc.mini.service.MemberService;

@Model
public class MemberListBean {

	private List<Member> list;

	@Inject
	private MemberService service;

	@PostConstruct
	private void postConstruct() {
		list = service.getAll();
	}

	public String delete(Member member) {
		member.getSecurity().setDelFlag(true);
		service.save(member);
		return "/view/admin/members?faces-redirect=true";
	}

	public List<Member> getList() {
		return list;
	}

	public void setList(List<Member> list) {
		this.list = list;
	}

}
