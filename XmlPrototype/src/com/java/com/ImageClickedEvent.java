package com.java.com;

import java.util.EventObject;

public class ImageClickedEvent extends EventObject{
	
	public int x, y;
	
	public ImageClickedEvent(Object source, int x, int y){
		super(source);
		this.x = x;
		this.y = y;
	}

}
