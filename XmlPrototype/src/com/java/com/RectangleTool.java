package com.java.com;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

public class RectangleTool extends BaseTool{

	public int width, height;
	
	public RectangleTool(Composite parent, int style, Image image,
			String content, int width, int height){
		super(parent, style);
	}
	
	public void addRectangle(){
		
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
