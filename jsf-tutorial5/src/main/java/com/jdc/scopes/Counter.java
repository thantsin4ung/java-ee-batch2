package com.jdc.scopes;

import java.io.Serializable;

import javax.enterprise.context.Dependent;

@SuppressWarnings("serial")
@Dependent
public class Counter implements Serializable {

	private int count;

	public void countUp() {
		count++;
	}

	public int getCount() {
		return count;
	}
}
