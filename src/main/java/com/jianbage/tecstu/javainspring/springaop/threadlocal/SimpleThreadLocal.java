package com.jianbage.tecstu.javainspring.springaop.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SimpleThreadLocal {
	private Map<Thread, Object> valueMap = Collections.synchronizedMap(new HashMap<Thread, Object>());
	
	public void set(Object newValue){
		valueMap.put(Thread.currentThread(), newValue);
	}
	
	public Object get(){
		Thread curThread = Thread.currentThread();
		Object obj = valueMap.get(curThread);
		if(obj == null && !valueMap.containsKey(curThread)){
			obj = initialValue();
			valueMap.put(curThread, obj);
		}
		return obj;
	}

	public Object initialValue() {
		return null;
	}
	
	public void remove(){
		valueMap.remove(Thread.currentThread());
	}
}
