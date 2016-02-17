package com.example.xmlparser.model;

public class MenuItem {
	String name;
	Class<?> className;

	public MenuItem() {
	}

	public MenuItem(String name, Class<?> className) {
		this.name = name;
		this.className = className;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getClassName() {
		return className;
	}

	public void setClassName(Class<?> className) {
		this.className = className;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "\n" + className.toString();
	}

}
