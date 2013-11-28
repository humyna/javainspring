package com.jianbage.tecstu.javainspring.springioc.propertyeditor.demo1;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class ChartBeanBeanInfo extends SimpleBeanInfo {
	@Override
	public PropertyDescriptor[] getPropertyDescriptors() {
		try {
			//①将TitlePositionEditor绑定到ChartBean的titlePosition属性中 
			PropertyDescriptor titlePropertyDescriptor = new PropertyDescriptor("titlePosition", ChartBean.class);
			titlePropertyDescriptor.setPropertyEditorClass(TitlePositionEditor.class);
			
			//②将InverseEditor绑定到ChartBean的inverse属性中
			PropertyDescriptor inversePropertyDescriptor = new PropertyDescriptor("inverse", ChartBean.class);
			inversePropertyDescriptor.setPropertyEditorClass(InversePositionEditor.class);
		} catch (IntrospectionException e) {
			e.printStackTrace();
			return null;
		}
		
		
		return super.getPropertyDescriptors();
	}
}
