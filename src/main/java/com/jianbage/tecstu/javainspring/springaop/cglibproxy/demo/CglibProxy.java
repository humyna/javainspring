package com.jianbage.tecstu.javainspring.springaop.cglibproxy.demo;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jianbage.tecstu.javainspring.springaop.common.PerformanceMonitor;

public class CglibProxy implements MethodInterceptor {
	private final static Logger logger = LoggerFactory.getLogger(CglibProxy.class);
	private Enhancer enhancer =  new Enhancer();
	
	public Object getProxy(Class clazz){
		enhancer.setSuperclass(clazz);//设置需要创建子类的类
		enhancer.setCallback(this);
		return enhancer.create();//通过字节码技术动态创建子类实例
	}
	
	//拦截父类所有方法的调用
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		PerformanceMonitor.begin(obj.getClass().getName()+ "." + method.getName());
		Object result = proxy.invokeSuper(obj, args);
		PerformanceMonitor.end();
		return result;
	}

}
