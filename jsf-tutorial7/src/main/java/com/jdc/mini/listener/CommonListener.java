package com.jdc.mini.listener;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.jdc.mini.entity.Security;

public class CommonListener {

	@PrePersist
	private void prePersist(CommonEntity entity) {
		Security security = entity.getSecurity();
		security.setCreation(LocalDateTime.now());
		security.setModfication(LocalDateTime.now());
	}

	@PreUpdate
	private void preUpdate(CommonEntity entity) {
		Security security = entity.getSecurity();
		security.setModfication(LocalDateTime.now());
	}
}
