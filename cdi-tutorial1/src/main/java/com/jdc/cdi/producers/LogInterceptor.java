package com.jdc.cdi.producers;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Loggable
@Interceptor
public class LogInterceptor {

	@AroundInvoke
	public Object writeLog(InvocationContext ctx) {

		Object obj = null;
		try {
			String className = ctx.getTarget().getClass().getName();
			String methodName = ctx.getMethod().getName();
			System.out.printf("Before Method Invoke %s#%s%n", className, methodName);
			obj = ctx.proceed();
			System.out.printf("After Method Invoke %s#%s%n", className, methodName);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}
}
