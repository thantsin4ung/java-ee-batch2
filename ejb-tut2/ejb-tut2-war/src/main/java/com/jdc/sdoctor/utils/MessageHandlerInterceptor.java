package com.jdc.sdoctor.utils;

import java.io.Serializable;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@MessageHandler
@Interceptor
public class MessageHandlerInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	private Properties props;

	public MessageHandlerInterceptor() {
		try {
			props = new Properties();
			props.load(getClass().getResourceAsStream("/message.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {

		Object obj = null;

		try {
			obj = ic.proceed();
		} catch (SmartDoctorException e) {
			FacesMessage message = new FacesMessage(null, props.getProperty(e.getMessageId()));
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

		return obj;
	}

}
