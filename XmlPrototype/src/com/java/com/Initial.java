package com.java.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.java.com.parser.ItemParser;

public class Initial {
	
	public static String getAbstractAddress(){
		String addr = Initial.class.getResource("/").getPath();
		return addr;
	}
	
	public static void main(String[] args){
		Display display = new Display();
		// main window
		Shell shell = new Shell(display);
		shell.setLayout(null);
		// multi line textarea
		shell.setText("Initialization Window");
		shell.setSize(600, 600);
		// open the main window
//		shell.pack();
		WorkSpace workSpace = WorkSpace.getSingleton();
		workSpace.setShell(shell);
		workSpace.initial();
		
		MenuSpace menuSpace = new MenuSpace(shell);
		menuSpace.initial();
		
		ItemParser itemParser = ItemParser.getSingleton();
		File toolBoxFile = new File(getAbstractAddress()+"/com/java/res/ToolBox.xml");
		List<Tool> result = itemParser.importXML(toolBoxFile);
		Iterator iter = result.iterator();
		while(iter.hasNext()){
			Tool tempTool = (Tool) iter.next();
			System.out.println("Tool is: "+ tempTool.id+"-"+tempTool.getType()+"::"+tempTool.getX()+" "+
					tempTool.getY()+" "+tempTool.getW()+" "+tempTool.getH());
		}
		
		ToolBox toolBox = ToolBox.getSingleton();
		toolBox.setShell(shell);
		toolBox.setTools(result);
		toolBox.initial();
		
		shell.open();
		// keep looping
		while(!shell.isDisposed()){
			// if display is not busy
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose();
	}
	
}
