package com.jdc.sdoctor.utils;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class SmartDoctorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String messageId;

	public SmartDoctorException(String messageId) {
		super();
		this.messageId = messageId;
	}

	public String getMessageId() {
		return messageId;
	}

}
