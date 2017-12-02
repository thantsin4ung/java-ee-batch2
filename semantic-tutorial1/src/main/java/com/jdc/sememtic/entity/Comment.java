package com.jdc.sememtic.entity;

import java.time.LocalDateTime;

public class Comment {

	private long id;
	private Question question;
	private Member owner;
	private String comment;
	private LocalDateTime commentTime;
}
