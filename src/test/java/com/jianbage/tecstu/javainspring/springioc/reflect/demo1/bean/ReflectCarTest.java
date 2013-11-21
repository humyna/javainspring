package com.jianbage.tecstu.javainspring.springioc.reflect.demo1.bean;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jianbage.tecstu.javaforspring.springioc.reflect.demo1.start.ReflectCar;
import com.jianbage.tecstu.javainspring.springioc.reflect.demo1.bean.Car;

public class ReflectCarTest {
	Logger logger = LoggerFactory.getLogger(ReflectCarTest.class);
	@Before
	public void setUp() {
		logger.info("Junit Test start......");
	}
	
	@Test
	public void test() throws Throwable {
		//1.general
		Car car = new Car();
		car.setBrand("红旗CA72");
		car.introduce();
		
		//2.reflect
		ReflectCar reflectCar = new ReflectCar();
		Car car1 = reflectCar.initCarByReflect();
		car1.introduce();
		
	}	
	
	@After
	public void destroy() {
		logger.info("Junit Test End......");
	}
}
