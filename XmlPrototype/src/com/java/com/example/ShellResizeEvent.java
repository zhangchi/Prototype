package com.java.com.example;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;

import com.java.com.Utils;

public class ShellResizeEvent {
	
	

//	public static void main(String[] args){
//		Display display = new Display();
//		Shell shell = new Shell(display);
//		Group group = new Group(shell, SWT.NONE);
//		group.setText("Work Space");
//		group.setBounds(10, 10, 200, 200);
//		
//		Label label = new Label(group, SWT.NONE);
//		Image image = new Image(Display.getDefault(), Utils.getAbstractAddr()+"com/java/res/pic/send_btn.png");
//		label.setImage(image);
//		label.setLocation(20, 20);
//		Cursor crossCursor = new Cursor(Display.getDefault(), SWT.CURSOR_SIZENWSE);
//		label.setCursor(crossCursor);
//		label.pack();
//		
//		shell.addControlListener(new ControlListener(){
//
//			@Override
//			public void controlMoved(ControlEvent arg0) {
//				// TODO Auto-generated method stub
//				System.out.println("control move");
//			}
//
//			@Override
//			public void controlResized(ControlEvent arg0) {
//				// TODO Auto-generated method stub
//				System.out.println("control resize");
//			}
//			
//		});
//		
//		label.pack();
//		shell.pack();
//		shell.open();
//		
//		while(!shell.isDisposed()){
//			if(!display.readAndDispatch()){
//				display.sleep();
//			}
//		}
//		
//		display.dispose();
//	}
	
//	 static int count = 0;
//
//	  public static void main(String[] args) {
//	    Display display = new Display();
//	    final Shell shell = new Shell(display);
//
//	    shell.setLayout(new RowLayout());
//
//	    final Composite composite = new Composite(shell, SWT.BORDER);
//	    composite.setLayout(new RowLayout());
//	    composite.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));
//	    composite.addControlListener(new ControlListener() {
//	      public void controlMoved(ControlEvent e) {
//	    	  System.out.println("Composite moved.");
//	      }
//
//	      public void controlResized(ControlEvent e) {
//	        System.out.println("Composite resize.");
//	      }
//	    });    
//	    
//	    Button buttonAdd = new Button(shell, SWT.PUSH);
//	    buttonAdd.setText("Add new button");
//	    buttonAdd.addSelectionListener(new SelectionAdapter() {
//	      public void widgetSelected(SelectionEvent e) {
//	        Button button = new Button(composite, SWT.PUSH);
//	        button.setText("Button #" + (count++));
//	        composite.layout(true);
//	        composite.pack();
//	      }
//	    });
//
//	    shell.setSize(450, 100);
//	    shell.open();
//
//	    while (!shell.isDisposed()) {
//	      if (!display.readAndDispatch()) {
//	        display.sleep();
//	      }
//	    }
//	    display.dispose();
//	  }
	
//	public static void main(String[] args) {
//
//	    Display display = new Display();
//
//	    final Shell shell = new Shell(display);
//
//	    GridLayout layout = new GridLayout();
//
//	    layout.numColumns = 2;
//
//	    shell.setLayout(layout);
//
//	    Label label = new Label(shell, SWT.WRAP);
//
//	    GridData labelData = new GridData();
//
//	    labelData.horizontalSpan = 2;
//
//	    labelData.horizontalAlignment = SWT.FILL;
//
//	    label.setLayoutData(labelData);
//
//	    label.setText(
//
//	        "This is lots of really nice text that " +
//
//	        "should wrap but does not. Is this a bug?");
//
//	    int style = SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL;
//
//	    List list = new List(shell, style);
//
//	    list.setItems(new String[] {"A", "B", "C", "D"});
//
//	    GridData listData =
//
//	        new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
//
//	    list.setLayoutData(listData);
//
//	    Button okButton = new Button(shell, SWT.PUSH);
//
//	    okButton.setText("Ok");
//
//	    Button cancelButton = new Button(shell, SWT.PUSH);
//
//	    cancelButton.setText("Cancel");
//
//	    shell.pack();
//
//	    shell.open();
//
//	    while (!shell.isDisposed()) {
//
//	        if (!display.readAndDispatch()) display.sleep();
//
//	    }
//
//	    display.dispose();
//
//	}
	
//	private Display	 display; 
//	private Shell	 shell; 
//	private FormLayout	 shellLayout; 
//
//	private ScrolledComposite	compositeScroller; 
//	private FormData dataScroller; 
//	private Composite	 compositeMain; 
//	private FormLayout	 layoutMain; 
//	private FormData	 dataMain; 
//
//	private Composite	 compositeInner; 
//	private FormLayout	 layoutInner; 
//	private FormData	 dataInner; 
//
//	private Label	 label1; 
//	private FormData	 dataLabel1; 
//	private Label	 label2; 
//	private FormData	 dataLabel2; 
//	private Label	 label3; 
//	private FormData	 dataLabel3; 
//
//	public ShellResizeEvent() 
//	{ 
//	display = new Display(); 
//	shell = new Shell(display); 
//	shell.setSize(640, 480); 
//	shellLayout = new FormLayout(); 
//	shellLayout.marginHeight = 5; 
//	shellLayout.marginWidth = 5; 
//	shell.setLayout(shellLayout); 
//
//	compositeScroller = new ScrolledComposite(shell, SWT.V_SCROLL); 
//	compositeMain = new Composite(compositeScroller, SWT.NONE); 
//	compositeScroller.setContent(compositeMain); 
//	layoutMain = new FormLayout(); 
//	layoutMain.marginHeight = 0; 
//	layoutMain.marginWidth = 0; 
//	compositeMain.setLayout(layoutMain); 
//
//	dataScroller = new FormData(); 
//	dataScroller.top = new FormAttachment(0, 5); 
//	dataScroller.left = new FormAttachment(0, 5); 
//	dataScroller.right = new FormAttachment (35, -5); 
//	dataScroller.bottom = new FormAttachment (100, -5); 
//	compositeScroller.setLayoutData(dataScroller); 
//
//	label1 = new Label(compositeMain, SWT.WRAP); 
//	label1.setText("1. This is a test."); 
//	dataLabel1 = new FormData(); 
//	dataLabel1.top = new FormAttachment(0, 5); 
//	dataLabel1.left = new FormAttachment(0, 5); 
//	dataLabel1.right = new FormAttachment (100, -5); 
//	label1.setLayoutData(dataLabel1); 
//
//	compositeInner = new Composite(compositeMain, SWT.NONE); 
//	compositeInner.setBackground(new Color(display, 204, 204, 255)); 
//	layoutInner = new FormLayout(); 
//	layoutInner.marginHeight = 0; 
//	layoutInner.marginWidth = 0; 
//	compositeInner.setLayout(layoutInner); 
//	dataInner = new FormData(); 
//	dataInner.top = new FormAttachment(label1, 5); 
//	dataInner.left = new FormAttachment(0, 5); 
//	dataInner.right = new FormAttachment (100, -5); 
//	compositeInner.setLayoutData(dataInner); 
//
//	label2 = new Label(compositeInner, SWT.WRAP); 
//	label2.setText("2. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test."); 
//	label2.setBackground(new Color(display, 204, 204, 255));	
//	dataLabel2 = new FormData(); 
//	dataLabel2.top = new FormAttachment(0, 5); 
//	dataLabel2.left = new FormAttachment(0, 5); 
//	dataLabel2.right = new FormAttachment (100, -5); 
//	dataLabel2.bottom = new FormAttachment (100, -5); 
//	label2.setLayoutData(dataLabel2); 
//
//	label3 = new Label(compositeMain, SWT.WRAP); 
//	label3.setText("3. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test."); 
//	dataLabel3 = new FormData(); 
//	dataLabel3.top = new FormAttachment(compositeInner, 5); 
//	dataLabel3.left = new FormAttachment(0, 5); 
//	dataLabel3.right = new FormAttachment (100, -5); 
//	label3.setLayoutData(dataLabel3); 
//
//	compositeScroller.addListener (SWT.Resize, new Listener () 
//	{ 
//	public void handleEvent (Event e) 
//	{ 
//	System.out.println("****************************"); 
//	System.out.println("Beginning of Listener..."); 
//	System.out.println("----------"); 
//	System.out.println("compositeMain - before setSize()"); 
//	System.out.println("compositeScroller WIDTH = " + compositeScroller.getClientArea().width); 
//	System.out.println("compositeScroller HEIGHT = " + compositeScroller.getClientArea().height); 
//	System.out.println("compositeMain WIDTH = " + compositeMain.getClientArea().width); 
//	System.out.println("compositeMain HEIGHT = " + compositeMain.getClientArea().height); 
//	System.out.println("----------"); 
//	compositeMain.setSize(compositeMain.computeSize(compositeScroller.getClientArea().width, SWT.DEFAULT)); 
//	System.out.println("compositeMain - after setSize()"); 
//	System.out.println("compositeScroller WIDTH = " + compositeScroller.getClientArea().width); 
//	System.out.println("compositeScroller HEIGHT = " + compositeScroller.getClientArea().height); 
//	System.out.println("compositeMain WIDTH = " + compositeMain.getClientArea().width); 
//	System.out.println("compositeMain HEIGHT = " + compositeMain.getClientArea().height); 
//	System.out.println("----------"); 
//	System.out.println("Labels - before Resize"); 
//	System.out.println("label1 WIDTH = " + label1.getBounds().width); 
//	System.out.println("label1 HEIGHT = " + label1.getBounds().height); 
//	System.out.println("label2 WIDTH = " + label2.getBounds().width); 
//	System.out.println("label2 HEIGHT = " + label2.getBounds().height); 
//	System.out.println("label3 WIDTH = " + label3.getBounds().width); 
//	System.out.println("label3 HEIGHT = " + label3.getBounds().height); 
//	System.out.println("----------"); 
//	dataLabel1.width = label1.getBounds().width; 
//	dataLabel2.width = label2.getBounds().width; 
//	dataLabel3.width = label3.getBounds().width; 
//	System.out.println("Labels - after Resize"); 
//	System.out.println("label1 WIDTH = " + label1.getBounds().width); 
//	System.out.println("label1 HEIGHT = " + label1.getBounds().height); 
//	System.out.println("label2 WIDTH = " + label2.getBounds().width); 
//	System.out.println("label2 HEIGHT = " + label2.getBounds().height); 
//	System.out.println("label3 WIDTH = " + label3.getBounds().width); 
//	System.out.println("label3 HEIGHT = " + label3.getBounds().height); 
//	System.out.println("----------"); 
//	System.out.println("****************************"); 
//	shell.layout(); 
//	} 
//	}); 
//
//	shell.open(); 
//	while (!shell.isDisposed()) 
//	{ 
//	if (!display.readAndDispatch()) 
//	display.sleep(); 
//	} 
//	display.dispose(); 
//	} 
//
//	public static void main(String[] args) 
//	{ 
//	ShellResizeEvent test = new ShellResizeEvent(); 
//	} 
	
//	public static void main(String[] args) {
//	    Display display = new Display();
//	    final Shell shell = new Shell(display, SWT.SHELL_TRIM
//	        | SWT.NO_BACKGROUND | SWT.NO_REDRAW_RESIZE | SWT.V_SCROLL
//	        | SWT.H_SCROLL);
//	    Image originalImage = null;
//	    FileDialog dialog = new FileDialog(shell, SWT.OPEN);
//	    dialog.setText("Open an image file or cancel");
//	    String string = dialog.open();
//	    if (string != null) {
//	      originalImage = new Image(display, string);
//	    }
//	    if (originalImage == null) {
//	      int width = 150, height = 200;
//	      originalImage = new Image(display, width, height);
//	      GC gc = new GC(originalImage);
//	      gc.fillRectangle(0, 0, width, height);
//	      gc.drawLine(0, 0, width, height);
//	      gc.drawLine(0, height, width, 0);
//	      gc.drawText("Default Image", 10, 10);
//	      gc.dispose();
//	    }
//	    final Image image = originalImage;
//	    final Point origin = new Point(0, 0);
//	    final ScrollBar hBar = shell.getHorizontalBar();
//	    hBar.addListener(SWT.Selection, new Listener() {
//	      public void handleEvent(Event e) {
//	        int hSelection = hBar.getSelection();
//	        int destX = -hSelection - origin.x;
//	        Rectangle rect = image.getBounds();
//	        shell.scroll(destX, 0, 0, 0, rect.width, rect.height, false);
//	        origin.x = -hSelection;
//	      }
//	    });
//	    final ScrollBar vBar = shell.getVerticalBar();
//	    vBar.addListener(SWT.Selection, new Listener() {
//	      public void handleEvent(Event e) {
//	        int vSelection = vBar.getSelection();
//	        int destY = -vSelection - origin.y;
//	        Rectangle rect = image.getBounds();
//	        shell.scroll(0, destY, 0, 0, rect.width, rect.height, false);
//	        origin.y = -vSelection;
//	      }
//	    });
//	    shell.addListener(SWT.Resize, new Listener() {
//	      public void handleEvent(Event e) {
//	        Rectangle rect = image.getBounds();
//	        Rectangle client = shell.getClientArea();
//	        hBar.setMaximum(rect.width);
//	        vBar.setMaximum(rect.height);
//	        hBar.setThumb(Math.min(rect.width, client.width));
//	        vBar.setThumb(Math.min(rect.height, client.height));
//	        int hPage = rect.width - client.width;
//	        int vPage = rect.height - client.height;
//	        int hSelection = hBar.getSelection();
//	        int vSelection = vBar.getSelection();
//	        if (hSelection >= hPage) {
//	          if (hPage <= 0)
//	            hSelection = 0;
//	          origin.x = -hSelection;
//	        }
//	        if (vSelection >= vPage) {
//	          if (vPage <= 0)
//	            vSelection = 0;
//	          origin.y = -vSelection;
//	        }
//	        shell.redraw();
//	      }
//	    });
//	    shell.addListener(SWT.Paint, new Listener() {
//	      public void handleEvent(Event e) {
//	        GC gc = e.gc;
//	        gc.drawImage(image, origin.x, origin.y);
//	        Rectangle rect = image.getBounds();
//	        Rectangle client = shell.getClientArea();
//	        int marginWidth = client.width - rect.width;
//	        if (marginWidth > 0) {
//	          gc.fillRectangle(rect.width, 0, marginWidth, client.height);
//	        }
//	        int marginHeight = client.height - rect.height;
//	        if (marginHeight > 0) {
//	          gc
//	              .fillRectangle(0, rect.height, client.width,
//	                  marginHeight);
//	        }
//	      }
//	    });
//	    shell.setSize(200, 150);
//	    shell.open();
//	    while (!shell.isDisposed()) {
//	      if (!display.readAndDispatch())
//	        display.sleep();
//	    }
//	    display.dispose();
//	  }
	 
//	public static void main(String[] args) {
//
//	    final String[] list = new String[128];
//
//	    for (int i = 0; i < list.length; i++) {
//
//	        list[i] = i + "-String-that-is-quite-long-" + i;
//
//	    }
//
//	    Display display = new Display();
//
//	    int style = SWT.SHELL_TRIM | SWT.NO_REDRAW_RESIZE;
//
//	    final Shell shell = new Shell(display, style);
//
//	    shell.addListener(SWT.Paint, new Listener() {
//
//	        public void handleEvent(Event event) {
//
//	            GC gc = event.gc;
//
//	            int height = gc.stringExtent("").y;
//
//	            for (int i = 0; i < list.length; i++) {
//
//	                gc.drawText(list[i], 2, i * height);
//
//	            }
//
//	        }
//
//	    });
//
//	    shell.setSize(200, 200);
//
//	    shell.open();
//
//	    while (!shell.isDisposed()) {
//
//	        if (!display.readAndDispatch()) display.sleep();
//
//	    }
//
//	    display.dispose();
//	}
	
	
}