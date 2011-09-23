package com.java.com.parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.java.com.Prop;
import com.java.com.Tool;
import com.java.com.Utils;
import com.java.com.WorkSpace;

public class ItemParser {
	
	public List<Tool> result;
	
	private static ItemParser singleton;
	
	public static ItemParser getSingleton(){
		if(singleton == null){
			singleton = new ItemParser();
		}
		return singleton;
	}
	
	private ItemParser(){
		
	}
	
	
	public void exportXML(){
		List<Tool> tempList = new ArrayList<Tool>();
		WorkSpace ws = WorkSpace.getSingleton();
		Control[] children = ws.getGroup().getChildren();
		for(int i=0; i<children.length; i++){
			System.out.println("Class is: "+ children[i].getClass().getName());
			System.out.println("Location is: "+children[i].getLocation().x+", "+children[i].getLocation().y);
		}
		Document document = DocumentHelper.createDocument();
		// add root
		Element toolsElement = document.addElement("tools");
		for(int i=0; i<children.length; i++){
			Button temp = null;
			if(children[i].getClass().getName().equals("org.eclipse.swt.widgets.Button")){
				temp = (Button)children[i];
			}
			Element toolElement = toolsElement.addElement("tool");
			toolElement.addAttribute("id", temp.getText());
			toolElement.addAttribute("type", children[i].getClass().getName());
			toolElement.addAttribute("x", Integer.toString(children[i].getLocation().x));
			toolElement.addAttribute("y", Integer.toString(children[i].getLocation().y));
			
			Element propsElement = toolElement.addElement("props");
			Element propElement = propsElement.addElement("prop");
			propElement.setText("prop content");
		}
		
		XMLWriter output;
		OutputFormat format = OutputFormat.createPrettyPrint();
		
		try{
			output = new XMLWriter(new FileWriter(Utils.getAbstractAddr()+"/com/java/res/workSpace.xml"), format);
			output.write(document);
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public List<Tool> importXML(File inputXml){
		result = new ArrayList<Tool>();
		try{
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(inputXml);
			Element root = document.getRootElement();
			int num = 0;
			
			for(Iterator iter = root.elementIterator(); iter.hasNext(); ){
				Tool tool = new Tool();
				List<Prop> props = new ArrayList<Prop>();
				
				Element element = (Element) iter.next();
				Attribute idAttr = element.attribute("id");
				Attribute typeAttr = element.attribute("type");
				Attribute xAttr = element.attribute("x");
				Attribute yAttr = element.attribute("y");
				Attribute wAttr = element.attribute("w");
				Attribute hAttr = element.attribute("h");
				tool.setId(Integer.parseInt(idAttr.getValue()));
				tool.setType(typeAttr.getValue());
				tool.setX(Integer.parseInt(xAttr.getValue()));
				tool.setY(Integer.parseInt(yAttr.getValue()));
				tool.setW(Integer.parseInt(wAttr.getValue()));
				tool.setH(Integer.parseInt(hAttr.getValue()));
				
				Element tempProps = element.element("props");
				for(Iterator innerIter = tempProps.elementIterator(); innerIter.hasNext(); ){
					Element tempProp = (Element) innerIter.next();
					Prop prop = new Prop();
					prop.setName("Prop");
					prop.setValue(tempProp.getText());
					props.add(prop);
				}
				tool.setProps(props);
				result.add(tool);
			}
			
			
		}catch(DocumentException e){
			e.printStackTrace();
		}
		
		return result;
	}
	
}
