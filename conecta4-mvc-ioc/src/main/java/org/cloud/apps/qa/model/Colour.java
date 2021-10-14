package org.cloud.apps.qa.model;

public enum Colour {
	O,X;
	
	public static Colour get(Integer i) {
		return Colour.values()[i];
	}
	
	
}
