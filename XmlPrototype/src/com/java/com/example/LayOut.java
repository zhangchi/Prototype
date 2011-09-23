package com.java.com.example;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class LayOut {
	public static void main(String[] args) {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    StackLayout layout = new StackLayout();
	    shell.setLayout(layout);
	    StackLayoutSelectionAdapter adapter = new StackLayoutSelectionAdapter(shell, layout);
	    Button one = new Button(shell, SWT.PUSH);
	    one.setText("one");
	    one.addSelectionListener(adapter);
	    Button two = new Button(shell, SWT.PUSH);
	    two.setText("two");
	    two.addSelectionListener(adapter);
	    Button three = new Button(shell, SWT.PUSH);
	    three.setText("three");
	    three.addSelectionListener(adapter);
	    layout.topControl = one;
	    shell.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        display.sleep();
	      }
	    }
	    display.dispose();
	  }
	}

	class StackLayoutSelectionAdapter extends SelectionAdapter {
	  Shell shell;

	  StackLayout layout;

	  public StackLayoutSelectionAdapter(Shell shell, StackLayout layout) {
	    this.shell = shell;
	    this.layout = layout;
	  }

	  public void widgetSelected(SelectionEvent event) {
	    Control control = layout.topControl;
	    Control[] children = shell.getChildren();
	    int i = 0;
	    for (int n = children.length; i < n; i++) {
	      Control child = children[i];
	      if (child == control) {
	        break;
	      }
	    }
	    i = i+1;
	    if (i >= children.length)
	      i = 0;
	    layout.topControl = children[i];
	    shell.layout();
	  }
}
