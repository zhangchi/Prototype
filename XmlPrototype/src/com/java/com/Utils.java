package com.java.com;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class Utils {

	public static String getAbstractAddr(){
		String addr = Utils.class.getResource("/").getPath();
		return addr;
	}
	
	public static Image resize(Image image, int width, int height){
		WorkSpace ws = WorkSpace.getSingleton();
		Image scaled = new Image(ws.getShell().getDisplay(), width, height);
		GC gc = new GC(scaled);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, width, height);
		gc.dispose();
		image.dispose();
		return scaled;
	}
}
