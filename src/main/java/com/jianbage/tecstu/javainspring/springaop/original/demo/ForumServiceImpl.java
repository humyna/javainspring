package com.jianbage.tecstu.javainspring.springaop.original.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jianbage.tecstu.javainspring.springaop.common.PerformanceMonitor;

public class ForumServiceImpl implements ForumService {
	private final static Logger logger = LoggerFactory.getLogger(ForumServiceImpl.class);
	
	@SuppressWarnings("static-access")
	public void removeTopic(int topicId) {
		PerformanceMonitor.begin("com.jianbage.tecstu.javainspring.springaop.original.demo.ForumServiceImpl.removeTopic");
		logger.info("del topic record[topicId = " + topicId + "]" );
		
		try {
			Thread.currentThread().sleep(20);
		} catch (InterruptedException e) {
			new RuntimeException(e);
		}
		
		PerformanceMonitor.end();
	}

	@SuppressWarnings("static-access")
	public void removeForum(int forumId) {
		PerformanceMonitor.begin("com.jianbage.tecstu.javainspring.springaop.original.demo.ForumServiceImpl.removeForum");
		logger.info("del topic record[forumId =" + forumId + "]");
		
		try {
			Thread.currentThread().sleep(20);
		} catch (InterruptedException e) {
			new RuntimeException(e);
		}
		
		PerformanceMonitor.end();
	}

}
