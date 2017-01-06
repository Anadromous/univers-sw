package com.balazsholczer.utils;

public enum PatientStringUtils {

	MAIN_MENU("MAIN MENU"),
	SHOW_ALL_STUDENTS("SHOW ALL PATIENTS"),
	
	FIRST_NAME("First name"),
	LAST_NAME("Last name"),
	GENDER("Gender"),
	AGE("BirthDate"),
	SAVE_BUTTON("Save"),
	CLEAR_BUTTON("Clear"), 
	UNIVERSITY("Agence/Site");
	
	private final String string;
	
	private PatientStringUtils(String string) {
		this.string = string;
	}
	
	public String getString() {
		return this.string;
	}
}
