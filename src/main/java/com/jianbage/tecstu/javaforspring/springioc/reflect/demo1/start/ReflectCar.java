package com.jianbage.tecstu.javaforspring.springioc.reflect.demo1.start;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jianbage.tecstu.javainspring.springioc.reflect.demo1.bean.Car;

public class ReflectCar {
	private final static Logger logger = LoggerFactory.getLogger(ReflectCar.class);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Car initCarByReflect() throws Throwable{
		logger.info("opt private var at Car by reflect start...");
		//step1 通过类装载器获取Car类对象
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		logger.info("current loader:"+ loader 
					+ "parent loader:"+loader.getParent()
					+ "grandparent loader:"+loader.getParent(). getParent());//类加载器
		
		Class clazz = loader.loadClass("com.jianbage.tecstu.javaforspring.springioc.reflect.demo1.bean.Car");
		
		//step2 获取类的默认构造器对象并通过它实例化Car
		Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
		Car car = (Car)cons.newInstance();
		
		//step3 通过反射方法设置属性
		Method setBrand = clazz.getDeclaredMethod("setBrand", String.class);
		setBrand.invoke(car, "红旗CA72");
		Method setColor = clazz.getDeclaredMethod("setColor", String.class);
		setColor.invoke(car, "黑色");
		Method setMaxSpeed = clazz.getDeclaredMethod("setMaxSpeed", int.class);
		setMaxSpeed.invoke(car, 200);
		logger.info("opt private var at Car by reflect end...");

		return car;
	}
}
