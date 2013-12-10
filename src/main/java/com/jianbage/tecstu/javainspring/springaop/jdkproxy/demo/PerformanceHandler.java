package com.jianbage.tecstu.javainspring.springaop.jdkproxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jianbage.tecstu.javainspring.springaop.common.PerformanceMonitor;

public class PerformanceHandler implements InvocationHandler {
	private final static Logger logger = LoggerFactory.getLogger(PerformanceHandler.class);
	
	private Object target;
	
	public PerformanceHandler(Object target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
		Object obj = method.invoke(target, args);
		PerformanceMonitor.end();
		return obj;
	}

}
