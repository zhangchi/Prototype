package com.java.com;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class ToolBox {

	private static ToolBox singleton = null;
	private List<Tool> tools;
	private Shell shell;
	private Group group;
	private Button button;
	public WorkSpace ws;
	private DragSource ds;
	private DropTarget dt;
	private Button newBtn;
	private DropTarget tempDT;
	private int id;
	
	public static ToolBox getSingleton(){
		if(singleton == null){
			singleton = new ToolBox();
		}
		return singleton;
	}
	
	private ToolBox(){
		
	}
	
	public void initial(){
		ws = WorkSpace.getSingleton();
		
		group = new Group(shell, SWT.SHADOW_OUT);
		group.setText("Tools");
		group.setBounds(5, 40, 80, 300);
//		group.setLayout()
		
		button = new Button(group, SWT.TOGGLE);
		button.setLocation(5, 60);
		button.setText("btn");
		button.pack();
		
		Image image = new Image(null, 20, 20);
		Color red = new Color(null, 255, 0, 0);
		GC gc = new GC(image);
		gc.setBackground(red);
		gc.fillRectangle(image.getBounds());
		gc.dispose();
		red.dispose();
		
		BaseTool baseTool = new BaseTool(group, SWT.TOGGLE);
		baseTool.setImage(image);
		baseTool.setContent("Hi");
		baseTool.setX(5);
		baseTool.setY(5);
		Point size = baseTool.computeSize(40, 20, false);
		baseTool.setSize(size);
		baseTool.pack();
		
		baseTool.addImageClickedListener(new ImageClickedListener(){

			@Override
			public void imageClicked(ImageClickedEvent e) {
				// TODO Auto-generated method stub
				final Label label = new Label(ws.getGroup(), SWT.NONE);
				final Image image = new Image(Display.getDefault(), Utils.getAbstractAddr()+"com/java/res/pic/send_btn.png");
				label.setImage(image);
				label.setLocation(20, 20);
				Cursor crossCursor = new Cursor(Display.getDefault(), SWT.CURSOR_SIZENWSE);
				label.setCursor(crossCursor);
				label.addMouseListener(new MouseAdapter(){

					@Override
					public void mouseUp(MouseEvent event) {
						// TODO Auto-generated method stub
//						label.setImage(Utils.resize(image, event.x - label.getLocation().x, event.y - label.getLocation().y));
						Image newImage = new Image(Display.getDefault(), 
								image.getImageData().scaledTo(event.x, event.y));
						label.setBounds(label.getBounds().x, label.getBounds().y, event.x, event.y);
						label.setImage(newImage);
//						label.setLocation(20, 20);
//						label.redraw();
					}
					
				});
				
//				
//				SuperLabel label = new SuperLabel(ws.getGroup(), SWT.RESIZE);
//				Image image = new Image(Display.getDefault(), Utils.getAbstractAddr()+"com/java/res/pic/send_btn.png");
//				label.setImage(image);
//				label.setLocation(20, 20);
//				Cursor crossCursor = new Cursor(Display.getDefault(), SWT.CURSOR_SIZENWSE);
//				label.setCursor(crossCursor);
//				label.addControlListener(new ControlListener(){
//
//					@Override
//					public void controlMoved(ControlEvent arg0) {
//						// TODO Auto-generated method stub
//						System.out.println("label moved");
//					}
//
//					@Override
//					public void controlResized(ControlEvent arg0) {
//						// TODO Auto-generated method stub
//						System.out.println("label resized");
//					}
//					
//				});
				label.pack();
			}
			
		});
		
		final Tree tree = new Tree(group, SWT.NONE);
	    for(int i=0; i<tools.size(); i++){
	    	Tool tempTool = tools.get(i);
	    	TreeItem item = new TreeItem(tree, SWT.NONE);
//	    	item.setText(Integer.toString(tempTool.getId()));
	    	item.setText(tempTool.getType());
	    }
	    tree.setLocation(5, 90);
	    Cursor handCursor = new Cursor(Display.getDefault(), SWT.CURSOR_HAND);
	    tree.setCursor(handCursor);
	    tree.pack();
		
		// create the drag source on the group
		ds = new DragSource(tree, DND.DROP_MOVE);
		ds.setTransfer(new Transfer[] {TextTransfer.getInstance()});
		ds.addDragListener(new DragSourceAdapter(){

			@Override
			public void dragSetData(DragSourceEvent event) {
				// TODO Auto-generated method stub
				event.data = tree.getSelection()[0].getText();
			}
			
		});
		
		dt = new DropTarget(ws.getGroup(), DND.DROP_MOVE);
		dt.setTransfer(new Transfer[] {TextTransfer.getInstance()});
		id = 0;
		dt.addDropListener(new DropTargetAdapter(){

			@Override
			public void drop(DropTargetEvent event) {
				// TODO Auto-generated method stub
			if(((String)event.data).contains("tool::")){	
				newBtn = new Button(ws.getGroup(), SWT.NONE);
				Image image = new Image(Display.getDefault(), Utils.getAbstractAddr()+"com/java/res/pic/send_btn.png");
				newBtn.setText(((String)event.data).substring(6));
				newBtn.setImage(image);
				int newX = event.x;
				int newY = event.y;
				int xX = ws.getGroup().getBounds().x;
				int yY = ws.getGroup().getBounds().y;
				newBtn.setBounds(event.x - ws.getGroup().getBounds().x -5, event.y - ws.getGroup().getBounds().y - 110
						, 100, 50);
				Cursor resizeCursor = new Cursor(Display.getDefault(), SWT.CURSOR_SIZENWSE);
				Cursor dragCursor = new Cursor(Display.getDefault(), SWT.CURSOR_HAND);
				newBtn.setCursor(dragCursor);
				//put it into the ws button list
//				ws.getBtnList().add(newBtn);
				ws.getBtnMap().put(id, newBtn);
//				newBtn.pack();
				newBtn.addMouseListener(new MouseAdapter(){

					@Override
					public void mouseUp(MouseEvent event) {
						// TODO Auto-generated method stub
						int eventX = event.x;
						int eventY = event.y;
						int srcX = newBtn.getLocation().x;
						int srcY = newBtn.getLocation().y;
						int width = newBtn.getBounds().width;
						int height = newBtn.getBounds().height;
						// drag only when the mouse is near to the left down corner
						if(Math.abs(eventX - width) <15 && Math.abs(eventY - height)<15){
							if(eventX>0 && eventY>0){
								newBtn.setBounds(srcX, srcY, eventX, eventY);
							}else
							if(eventX < 0 && eventY<0){
								newBtn.setBounds(eventX+srcX, eventY+srcY, -eventX, -eventY);
							}else
							if(eventX < 0 && eventY>0){
								newBtn.setBounds(eventX+srcX, srcY, -eventX, eventY);
							}else
							if(eventX > 0 && eventY < 0){
								newBtn.setBounds(srcX, eventY+srcY, eventX, -eventY);
							}
						}
						
					}
					
				});
				
//				newBtn.addListener(SWT.Move, new Listener(){
//
//					@Override
//					public void handleEvent(Event e) {
//						// TODO Auto-generated method stub
//						System.out.println("new location: "+ e.x+e.y);
//					}
//					
//				});
				
				DragSource xds = new DragSource((Button)ws.getBtnMap().get(id), DND.DROP_MOVE);
				xds.setTransfer(new Transfer[] {TextTransfer.getInstance()});
				xds.addDragListener(new DragSourceAdapter(){

					@Override
					public void dragSetData(DragSourceEvent event) {
						// TODO Auto-generated method stub
						event.data = newBtn.getText();
					}
					
				});
//				DropTarget tempDT = new DropTarget(ws.getGroup(), DND.DROP_MOVE);
//				tempDT.setTransfer(new Transfer[] {TextTransfer.getInstance()});
				dt.addDropListener(new DropTargetAdapter(){

					@Override
					public void drop(DropTargetEvent event) {
						// TODO Auto-generated method stub
						newBtn.setLocation(event.x - ws.getGroup().getBounds().x, event.y - ws.getGroup().getBounds().y);
//						System.out.println("new location is: "+event.x +", "+event.y);
					}
					
				});
				
				newBtn.addSelectionListener(new SelectionListener(){
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						PropertyEditor propertyEditor = PropertyEditor.getSingleton();
						propertyEditor.setDisplay(Display.getCurrent());
						propertyEditor.setValue(newBtn.getClass().getName());
						propertyEditor.init();
					}
					
				});
				
				id++;
				
//				Image image = new Image(Display.getDefault(), Utils.getAbstractAddr()+"com/java/res/pic/play.svg");
//				
//				BaseTool baseTool = new BaseTool(ws.getGroup(), SWT.NONE);
//				baseTool.setImage(image);
//				baseTool.setContent("new one");
//				int eventX = event.x;
//				int eventY = event.y;
//				int srcX = ws.getGroup().getLocation().x;
//				int srcY = ws.getGroup().getLocation().y;
//				baseTool.setX(event.x);
//				baseTool.setY(event.y);
//				Point size = baseTool.computeSize(SWT.DEFAULT, SWT.DEFAULT, false);
//				baseTool.setSize(size);
//				baseTool.pack();
			}
		}	
		});
	
	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Tool> getTools() {
		return tools;
	}

	public void setTools(List<Tool> tools) {
		this.tools = tools;
	}
	
	
}
