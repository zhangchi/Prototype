package com.java.com;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import com.java.com.parser.ItemParser;

public class MenuSpace {
	
	private Shell shell;
	private Menu menuBar, fileMenu, helpMenu;
	private MenuItem fileMenuHeader, helpMenuHeader;
	private MenuItem fileExitItem, fileExportItem, helpGetItem;
	
	public MenuSpace(Shell shell){
		this.shell = shell;
	}
	
	public void initial(){
		menuBar = new Menu(shell, SWT.BAR);
		fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		fileMenuHeader.setText("File");
		
		fileMenu = new Menu(shell, SWT.DROP_DOWN);
		fileMenuHeader.setMenu(fileMenu);
		
		fileExportItem = new MenuItem(fileMenu, SWT.PUSH);
		fileExportItem.setText("Export xml");
		
		fileExitItem = new MenuItem(fileMenu, SWT.PUSH);
		fileExitItem.setText("Exit");
		
		helpMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		helpMenuHeader.setText("Help");
		
		helpMenu = new Menu(shell, SWT.DROP_DOWN);
		helpMenuHeader.setMenu(helpMenu);
		
		helpGetItem = new MenuItem(helpMenu, SWT.PUSH);
		helpGetItem.setText("Get help");
		
		fileExportItem.addSelectionListener(new fileExportListener());
		
		shell.setMenuBar(menuBar);
	}
	
	class fileExportListener implements SelectionListener{

		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {
			// TODO Auto-generated method stub
			ItemParser itemParser = ItemParser.getSingleton();
			itemParser.exportXML();
		}

		@Override
		public void widgetSelected(SelectionEvent arg0) {
			// TODO Auto-generated method stub
			ItemParser itemParser = ItemParser.getSingleton();
			itemParser.exportXML();
		}
		
	}
}
