package com.jianbage.tecstu.javainspring.springaop.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethodPerformance {
	private final static Logger logger = LoggerFactory.getLogger(MethodPerformance.class);
	
	private long begin;
	private long end;
	private String serviceMethod;
	public MethodPerformance(String serviceMethod) {
		this.serviceMethod = serviceMethod;
		this.begin = System.currentTimeMillis();
	}
	
	public void printPerformance(){
		end = System.currentTimeMillis();
		long elapse =  end -begin;
		logger.info("method[" + serviceMethod + "] expend " + elapse + " milliseconds");
	}
}
