package com.jianbage.tecstu.javainspring.springioc.reflect.demo1.bean;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jianbage.tecstu.javaforspring.springioc.reflect.demo1.start.ReflectPrivateCar;

public class ReflectPrivateCarTest {
	Logger logger = LoggerFactory.getLogger(ReflectPrivateCarTest.class);
	@Before
	public void setUp() {
		logger.info("Junit Test start......");
	}
	
	@Test
	public void test() throws Throwable {
		ReflectPrivateCar reflectPrivateCar = new ReflectPrivateCar();
		reflectPrivateCar.initPrivateCarByReflect();
	}	
	
	@After
	public void destroy() {
		logger.info("Junit Test End......");
	}
}
