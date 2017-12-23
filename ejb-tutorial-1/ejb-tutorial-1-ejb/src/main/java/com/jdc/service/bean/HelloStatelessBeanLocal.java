package com.jdc.service.bean;

import javax.ejb.Local;

@Local
public interface HelloStatelessBeanLocal {

	String getMessage();
}
