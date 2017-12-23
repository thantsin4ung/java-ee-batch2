package com.jdc.service.bean;

import java.util.concurrent.TimeUnit;

import javax.ejb.AccessTimeout;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@LocalBean
@Startup
@AccessTimeout(unit = TimeUnit.SECONDS, value = 1)
public class CounterBean {

	private int count;

	@Lock(LockType.WRITE)
	public void countUp() {

		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count++;
	}

	@Lock(LockType.READ)
	public int getCount() {
		return count;
	}

}
