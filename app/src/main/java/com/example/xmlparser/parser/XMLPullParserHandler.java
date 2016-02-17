package com.example.xmlparser.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.XmlResourceParser;

import com.example.xmlparser.model.MenuItem;

public class XMLPullParserHandler {
	static ArrayList<MenuItem> arrMenuItem = new ArrayList<MenuItem>();

	public XMLPullParserHandler() {
		//arrMenuItem = new ArrayList<MenuItem>();
	}

	public static List<MenuItem> parseXML(XmlResourceParser xml) {
		MenuItem menuItem = null;
		try {
			while (xml.next() != XmlPullParser.END_DOCUMENT) {
				int eventType = xml.getEventType();
				String tagname = xml.getName();
				if (eventType == XmlPullParser.START_TAG) {
					if (tagname.equalsIgnoreCase("menu")) {
						String name = xml.getAttributeValue(null, "name");
						String className = xml.getAttributeValue(null, "class");
						menuItem = new MenuItem(name, Class.forName(className));
					}
				} else if (eventType == XmlPullParser.END_TAG) {
					if (tagname.equalsIgnoreCase("menu")) {
						arrMenuItem.add(menuItem);
					}
				}
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrMenuItem;
	}

}

// ArrayList<Employee> arrEmployee;
// Employee employee;
// String text;
// public XMLPullParserHandler() {
// arrEmployee = new ArrayList<Employee>();
// }
// public List<Employee> parseXML(XmlResourceParser xml){
// try {
// while(xml.next() != XmlPullParser.END_DOCUMENT){
// String tagname = xml.getName();
// int eventType = xml.getEventType();
// if(eventType == XmlPullParser.START_TAG){
// if(tagname.equalsIgnoreCase("employee")){
// employee = new Employee();
// }
// }else if(eventType == XmlPullParser.TEXT){
// text = xml.getText();
// }else if(eventType == XmlPullParser.END_TAG){
// if(tagname.equalsIgnoreCase("employee")){
// arrEmployee.add(employee);
// }else if(tagname.equalsIgnoreCase("id")){
// employee.setId(Integer.parseInt(text));
// }else if(tagname.equalsIgnoreCase("name")){
// employee.setName(text);
// }else if(tagname.equalsIgnoreCase("department")){
// employee.setDepartment(text);
// }else if(tagname.equalsIgnoreCase("email")){
// employee.setEmail(text);
// }
// }
// }
// } catch (XmlPullParserException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// } catch (IOException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// return arrEmployee;
// }

