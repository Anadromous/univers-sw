package com.balazsholczer.utils;

public enum StringUtils {

	MENU_STUDENT("PATIENTS"),
	MENU_UNIVERSITY("AGENCY/CLINIC"),
	MENU_ADD_STUDENT("Add Patient"),
	MENU_REMOVE_STUDENT("Remove Patient"),
	MENU_OPERATIONS("Operations"),
	
	;
	
	private final String string;
	
	private StringUtils(String string) {
		this.string = string;
	}
	
	public String getString() {
		return this.string;
	}
}
