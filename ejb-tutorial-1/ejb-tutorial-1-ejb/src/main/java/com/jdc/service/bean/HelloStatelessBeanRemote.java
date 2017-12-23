package com.jdc.service.bean;

import javax.ejb.Remote;

@Remote
public interface HelloStatelessBeanRemote {

	String getRemoteMessage();
}
