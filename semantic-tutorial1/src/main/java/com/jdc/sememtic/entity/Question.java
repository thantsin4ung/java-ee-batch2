package com.jdc.sememtic.entity;

import java.time.LocalDateTime;

public class Question {

	private long id;
	private String title;
	private Category category;
	private String question;
	private LocalDateTime createTime;
	private Member owner;
}
