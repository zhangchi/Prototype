package com.java.com;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class WorkSpace {

	private static WorkSpace singleton = null;
	
	private Shell shell;
	private Button button;
	private Group group;
	private Label label;
	private List<Button> btnList;
	private Map<Integer, Button> btnMap = new ConcurrentHashMap<Integer, Button>();
	
	private WorkSpace(){
	
	}
	
	public static WorkSpace getSingleton(){
		if(singleton == null){
			singleton = new WorkSpace();
		}
		return singleton;
	}
	
	public void initial(){
		group = new Group(shell, SWT.SHADOW_OUT);
		group.setText("Work Space");
		group.setBounds(100, 100, 400, 400);
		
		button = new Button(group, SWT.PUSH);
		button.setLocation(20, 40);
		button.setText("Test");
		button.pack();
		
//		button.addDragDetectListener(listener)
//		group.pack();
	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public List<Button> getBtnList() {
		return btnList;
	}

	public void setBtnList(List<Button> btnList) {
		this.btnList = btnList;
	}

	public Map<Integer, Button> getBtnMap() {
		return btnMap;
	}

	public void setBtnMap(Map<Integer, Button> btnMap) {
		this.btnMap = btnMap;
	}
	
	
	
}
