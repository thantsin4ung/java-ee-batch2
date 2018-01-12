package com.jdc.sdoctor.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jdc.sdoctor.entity.Token;
import com.jdc.sdoctor.model.TokenModel;

@Named
@ViewScoped
public class TokensBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private LocalDate date;
	private List<Token> tokens;
	private Token newToken;

	@EJB
	private TokenModel model;

	@PostConstruct
	public void init() {
		date = LocalDate.now();
		newToken = new Token();
		newToken.setRefDate(LocalDate.now());
		search();
	}

	public void search() {
		tokens = model.find(date);
	}

	public String takeToken() {
		model.takeToken(newToken);
		return "/doctor/tokens?faces-redirect=true";
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}

	public Token getNewToken() {
		return newToken;
	}

	public void setNewToken(Token newToken) {
		this.newToken = newToken;
	}

}
