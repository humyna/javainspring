package com.jianbage.tecstu.javaforspring.springioc.propertyeditor.demo1;

import javax.swing.JPanel;

public class ChartBean extends JPanel {
	
	private int titlePosition = 1;
	private boolean inverse;
	public int getTitlePosition() {
		return titlePosition;
	}
	public void setTitlePosition(int titlePosition) {
		this.titlePosition = titlePosition;
	}
	public boolean isInverse() {
		return inverse;
	}
	public void setInverse(boolean inverse) {
		this.inverse = inverse;
	}
	
}
