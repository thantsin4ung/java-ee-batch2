package com.jdc.mini.beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.mini.entity.Member;
import com.jdc.mini.service.MemberService;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class MemberBean implements Serializable {

	private Member member;
	private boolean showPopup;

	@Inject
	private MemberService service;

	public void editMember(Member member) {
		this.member = member;
		showPopup = true;
	}

	public void addMember() {
		this.member = new Member();
		showPopup = true;
	}

	public String save() {
		service.save(member);
		return "/admin/members?faces-redirect=true";
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public boolean isShowPopup() {
		return showPopup;
	}

	public void setShowPopup(boolean showPopup) {
		this.showPopup = showPopup;
	}
}
