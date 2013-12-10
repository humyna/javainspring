package com.jianbage.tecstu.javainspring.springaop.common;

//import com.jianbage.tecstu.javainspring.springaop.original.demo.ForumService;
//import com.jianbage.tecstu.javainspring.springaop.original.demo.ForumServiceImpl;
//import com.jianbage.tecstu.javainspring.springaop.jdkproxy.demo.ForumService;
//import com.jianbage.tecstu.javainspring.springaop.jdkproxy.demo.ForumServiceImpl;
import com.jianbage.tecstu.javainspring.springaop.cglibproxy.demo.CglibProxy;
import com.jianbage.tecstu.javainspring.springaop.cglibproxy.demo.ForumServiceImpl;


public class MothodPerformanceMonitorTest {

	public static void main(String[] args) {
		
//		ForumService forumService = new ForumServiceImpl();
		//1.original test
//		forumService.removeTopic(125);
//		forumService.removeForum(1024);
		
		//2.jdk-proxy test
//		PerformanceHandler handler = new PerformanceHandler(forumService);
//		ForumService proxy = (ForumService) Proxy.newProxyInstance(forumService.getClass().getClassLoader(), forumService.getClass().getInterfaces(), handler);
//		proxy.removeTopic(125);
//		proxy.removeForum(1024);
		
		//3.cglib-proxy test
		CglibProxy proxy = new CglibProxy();
		ForumServiceImpl forumService = (ForumServiceImpl)proxy.getProxy(ForumServiceImpl.class);
		forumService.removeTopic(125);
		forumService.removeForum(1024);
	}

}
