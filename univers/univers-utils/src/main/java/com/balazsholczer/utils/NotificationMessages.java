package com.balazsholczer.utils;

public enum NotificationMessages {
	
	STUDENT_SAVE_VALIDATION_ERROR_TITLE("ERROR"), 
	STUDENT_SAVE_VALIDATION_ERROR_DESCRIPTION("Fields must be filled!"),
	
	STUDENT_SAVE_SUCCESS_TITLE("SAVE"), 
	STUDENT_SAVE_SUCCESS_DESCRIPTION("Student has been saved!"), 
	STUDENT_REMOVE_BUTTON("remove"), 
	STUDENT_REMOVE_SUCCESS_TITLE("REMOVE"), 
	STUDENT_REMOVE_SUCCESS_DESCRIPTION("Student(s) successfully removed!"), 
	UNIVERSITY_SAVED_VALIDATION_ERROR_TITLE("ERROR"), 
	UNIVERSITY_SAVED_VALIDATION_ERROR_DESCRIPTION("Field must be filled!"),
	
	UNIVERSITY_SAVE_SUCCESS_TITLE("SAVE"),
	UNIVERSITY_SAVE_SUCCESS_DESCRIPTION("University saved successfully!"),
	STUDENT_SAVE_INVALID_TITLE("ERROR"),
	STUDENT_SAVE_INVALID_DESCRIPTION("Must have at least one university!")
	
	;
	
	private final String string;
	
	private NotificationMessages(String string) {
		this.string = string;
	}

	public String getString() {
		return this.string;
	}
}
