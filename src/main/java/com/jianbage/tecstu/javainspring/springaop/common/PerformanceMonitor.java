package com.jianbage.tecstu.javainspring.springaop.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerformanceMonitor {
	private final static Logger logger = LoggerFactory.getLogger(PerformanceMonitor.class);
	
	private static ThreadLocal<MethodPerformance> performaceRecord =  new ThreadLocal<MethodPerformance>();
	
	public static void begin(String method){
		logger.info("begin monitor..." );
		MethodPerformance mp = new MethodPerformance(method);
		performaceRecord.set(mp);
	}
	
	public static void end(){
		logger.info("end monitor...");
		MethodPerformance mp = performaceRecord.get();
		mp.printPerformance();
	}
}
