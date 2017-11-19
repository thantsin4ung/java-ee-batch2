package com.jdc.mini.producer;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.mini.entity.Reasons;
import com.jdc.mini.service.ReasonService;

@ApplicationScoped
public class ReasonProducer {

	private List<Reasons> list;

	@Inject
	private ReasonService service;

	@PostConstruct
	private void postConstruct() {
		load(null);
	}

	public void load(@Observes Reasons r) {
		list = service.getAll();
	}

	@Named
	@Produces
	public List<Reasons> getAllReasons() {
		return list;
	}

	@Named
	@Produces
	public List<Reasons> getReasons() {
		return list.stream().filter(a -> !a.getSecurity().isDelFlag()).collect(Collectors.toList());
	}
}
