package com.jdc.sememtic.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.sememtic.entity.Member;
import com.jdc.sememtic.entity.Question;
import com.jdc.sememtic.service.QuestionService;

@Model
public class QuestionEditBean {

	@Inject
	private Member loginUser;
	private Question question;

	@Inject
	private QuestionService service;

	@PostConstruct
	private void init() {
		question = new Question();
		question.setOwner(loginUser);
	}

	public String save() {
		service.save(question);
		return "/index?faces-redirect=true";
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
