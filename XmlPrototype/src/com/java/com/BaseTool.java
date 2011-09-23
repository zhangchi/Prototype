package com.java.com;

import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class BaseTool extends Composite{
	public int id;
	public String content;
	public int x, y;
	public Image image;
	Vector imageClickedListeners = new Vector();
	
	public BaseTool(Composite parent, int style){
		super(parent, style);
		
		addDisposeListener(new DisposeListener(){

			@Override
			public void widgetDisposed(DisposeEvent arg0) {
				// TODO Auto-generated method stub
				// this is a reserved method, may not have to dispose image
				image.dispose();
//				this.widgetDisposed(arg0);
			}
			
		});
		
		// repaint this widget
		addPaintListener(new PaintListener(){

			@Override
			public void paintControl(PaintEvent arg0) {
				// TODO Auto-generated method stub
				BaseTool.this.paintControl(arg0);
			}
			
		});
		
		addMouseListener(new MouseAdapter(){

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.button == 1){
					BaseTool.this.mouseDown(e);
				}
			}
			
		});
	}
	
	void paintControl(PaintEvent e){
		GC gc = e.gc;
		if(image!=null){
			gc.drawImage(image, x, y);
			x = image.getBounds().width + 5;
		}
		// content will be next to the image
		if(content!=null){
			gc.drawString(content, x, y);
		}
	}
	
	// preferred bounds for the widget
	public Point computeSize(int wHint, int hHint, boolean changed){
		int width = 0, height = 0;
		if(image!=null){
			Rectangle bounds = image.getBounds();
			width = bounds.width+5;
			height = bounds.width;
		}
		if(content!=null){
			GC gc = new GC(this);
			Point extent = gc.stringExtent(content);
			gc.dispose();
			width += extent.x;
			height = Math.max(height, extent.y);
		}
		
		// in case user does not define the wHint, hHint
		if(wHint != SWT.DEFAULT) width = wHint;
		if(hHint != SWT.DEFAULT) height = hHint;
		
		return new Point(width+2, height+2);
	}
	
	public void mouseDown(MouseEvent event){
		ImageClickedEvent e = new ImageClickedEvent(this, event.x, event.y);
		int size = imageClickedListeners.size();
		for(int i=0; i<size; i++){
			ImageClickedListener listener = (ImageClickedListener) imageClickedListeners.elementAt(i);
			listener.imageClicked(e);
		}
	}
	
	public void addImageClickedListener(ImageClickedListener listener){
		imageClickedListeners.addElement(listener);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	
}
