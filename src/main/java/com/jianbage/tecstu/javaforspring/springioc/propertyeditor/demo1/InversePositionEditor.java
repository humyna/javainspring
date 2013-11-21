package com.jianbage.tecstu.javaforspring.springioc.propertyeditor.demo1;

import java.beans.PropertyEditorSupport;

public class InversePositionEditor extends PropertyEditorSupport {
	private String[] options = new String[]{"TRUE","FALSE"};
	
	//①代表可选属性值的字符串标识数组
		@Override
		public String[] getTags() {
			return options;
		}
		
		//②代表属性初始值的字符串
		@Override
		public String getJavaInitializationString() {
			return "" + getValue();
		}
		
		//③将内部属性值转换为对应的字符串表示形式，供属性编辑器显示之用
		@Override
		public String getAsText() {
			int value = (Integer)getValue();
			return options[value];
		}
		//④将外部设置的字符串转换为内部属性的值
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			for (int i = 0; i < options.length; i++) {
				if(options[i].equals(text)){
					setValue(i);
					return;
				}
			}
		}
}
