package com.jianbage.tecstu.javaforspring.springioc.reflect.demo1.start;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jianbage.tecstu.javainspring.springioc.reflect.demo1.bean.PrivateCar;

public class ReflectPrivateCar {
	private final static Logger logger = LoggerFactory.getLogger(ReflectPrivateCar.class);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PrivateCar initPrivateCarByReflect() throws Throwable{
		logger.info("opt private var at PrivateCar by reflect start...");
		//step1 通过类装载器获取PrivateCar类对象
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("com.jianbage.tecstu.javaforspring.springioc.reflect.demo1.bean.PrivateCar");
		
		//step2 获取类的默认构造器对象并通过它实例化PrivateCar
		Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
		PrivateCar car = (PrivateCar)cons.newInstance();
		
		Field colorField = clazz.getDeclaredField("color");
		colorField.setAccessible(true);
		colorField.set(car, "red");
		
		Method driveMtd = clazz.getDeclaredMethod("drive", (Class[])null);
		driveMtd.setAccessible(true);
		driveMtd.invoke(car, (Object[])null);
		logger.info("opt private var at PrivateCar by reflect end...");
		
		return car;
	}
}
