package com.java.com;

import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.widgets.Composite;

public class DragListener {

	private DragSource ds;
	private DropTarget dt;
	private Composite source;
	private Composite target;
	
	public void setDragListener(){
		
	}

	public DragSource getDs() {
		return ds;
	}

	public void setDs(DragSource ds) {
		this.ds = ds;
	}

	public DropTarget getDt() {
		return dt;
	}

	public void setDt(DropTarget dt) {
		this.dt = dt;
	}

	public Composite getSource() {
		return source;
	}

	public void setSource(Composite source) {
		this.source = source;
	}

	public Composite getTarget() {
		return target;
	}

	public void setTarget(Composite target) {
		this.target = target;
	}
	
	
}
