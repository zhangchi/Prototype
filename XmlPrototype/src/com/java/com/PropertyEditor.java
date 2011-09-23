package com.java.com;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class PropertyEditor {
	
	public Display display;
	public String value;
	
	private static  PropertyEditor singleton;
	
	private PropertyEditor(){
		
	}
	
	public static PropertyEditor getSingleton(){
		if(singleton==null){
			singleton = new PropertyEditor();
		}
		return singleton;
	}
	
	public void init(){
		Shell shell = new Shell(display);
		shell.setText("Property");
		shell.setSize(500, 200);
		Label label = new Label(shell, SWT.NONE);
		label.setText(value);
		label.pack();
		shell.open();
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
