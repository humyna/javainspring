package com.jianbage.tecstu.javainspring.springioc.propertyeditor.demo2;

import java.beans.PropertyEditorSupport;

public class CustomCarEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text == null || text.indexOf(",") == -1){  
            throw new IllegalArgumentException("设置的字符串格式不正确");  
        }  
        String[] infos = text.split(",");  
        Car car = new Car();  
        car.setBrand(infos[0]);  
        car.setMaxSpeed(Integer.parseInt(infos[1]));  
        car.setPrice(Double.parseDouble(infos[2]));  
  
         //②调用父类的setValue()方法设置转换后的属性对象  
        setValue(car); 
	}
}
