package com.balazsholczer.utils;

public enum UniversityStringUtils {

	UNIVERSITY_NAME("Name"),
	UNIVERSITY_COUNTRY("Country"),
	UNIVERSITY_CITY("City"),
	
	UNIVERSITY_SAVE_SUCCESS_TITLE("SAVE"),
	UNIVERSITY_SAVE_SUCCESS_DESCRIPTION("University saved successfully!")
	
	;
	
	private final String string;
	
	private UniversityStringUtils(String string) {
		this.string = string;
	}
	
	public String getString() {
		return this.string;
	}
}
