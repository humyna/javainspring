package com.jianbage.tecstu.javainspring.springaop.cglibproxy.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForumServiceImpl implements ForumService {
	private final static Logger logger = LoggerFactory.getLogger(ForumServiceImpl.class);
	
	@SuppressWarnings("static-access")
	public void removeTopic(int topicId) {
		logger.info("del topic record[topicId = " + topicId + "]" );
		
		try {
			Thread.currentThread().sleep(20);
		} catch (InterruptedException e) {
			new RuntimeException(e);
		}
	}

	@SuppressWarnings("static-access")
	public void removeForum(int forumId) {
		logger.info("del topic record[forumId =" + forumId + "]");
		
		try {
			Thread.currentThread().sleep(20);
		} catch (InterruptedException e) {
			new RuntimeException(e);
		}
	}

}
