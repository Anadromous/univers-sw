package com.balazsholczer.ui.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.balazsholczer.model.entity.Student;
import com.balazsholczer.model.entity.University;
import com.balazsholczer.service.addstudent.AddStudentService;
import com.balazsholczer.service.showalluniversities.ShowAllUniversitiesService;
import com.balazsholczer.utils.Gender;
import com.balazsholczer.utils.NotificationMessages;
import com.balazsholczer.utils.StudentsStringUtils;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class AddStudentMainLayoutFactory {

	private class AddStudentMainLayout extends VerticalLayout implements Button.ClickListener {

		private TextField firstName;
		private TextField lastName;
		private TextField age;
		private ComboBox gender;
		private ComboBox university;
		private Button saveButton;
		private Button clearButton;

		private BeanFieldGroup<Student> fieldGroup;
		private Student student;
		
		private StudentSavedListener studentSavedLister;
		
		public AddStudentMainLayout(StudentSavedListener studentSavedLister) {
			this.studentSavedLister = studentSavedLister;
		}

		public AddStudentMainLayout init() {

			fieldGroup = new BeanFieldGroup<Student>(Student.class);
			student = new Student();

			firstName = new TextField(StudentsStringUtils.FIRST_NAME.getString());
			lastName = new TextField(StudentsStringUtils.LAST_NAME.getString());
			age = new TextField(StudentsStringUtils.AGE.getString());
			gender = new ComboBox(StudentsStringUtils.GENDER.getString());

			saveButton = new Button(StudentsStringUtils.SAVE_BUTTON.getString());
			clearButton = new Button(StudentsStringUtils.CLEAR_BUTTON.getString());
			
			university = new ComboBox(StudentsStringUtils.UNIVERSITY.getString());
			university.setWidth("100%");
			
			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);

			saveButton.addClickListener(this);
			clearButton.addClickListener(this);
			
			gender.addItem(Gender.MALE.getString());
			gender.addItem(Gender.FEMALE.getString());
			
			firstName.setNullRepresentation("");
			lastName.setNullRepresentation("");
			age.setNullRepresentation("");

			return this;
		}

		public AddStudentMainLayout bind() {
			fieldGroup.bindMemberFields(this);
			fieldGroup.setItemDataSource(student);
			return this;
		}

		public Component layout() {

			setMargin(true);

			GridLayout gridLayout = new GridLayout(2, 4);
			gridLayout.setSizeUndefined();
			gridLayout.setSpacing(true);

			gridLayout.addComponent(firstName, 0, 0);
			gridLayout.addComponent(lastName, 1, 0);

			gridLayout.addComponent(age, 0, 1);
			gridLayout.addComponent(gender, 1, 1);
			
			gridLayout.addComponent(university, 0, 2, 1, 2);

			gridLayout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 3);

			return gridLayout;
		}

		public void buttonClick(ClickEvent event) {
			if( event.getSource() == this.saveButton ) {
				save();
			} else {
				clearField();
			}
		}

		private void save() {
			
			if( !isSaveOperationValid() ) {
				
				Notification.show(NotificationMessages.STUDENT_SAVE_INVALID_TITLE.getString(), 
						NotificationMessages.STUDENT_SAVE_INVALID_DESCRIPTION.getString(), Type.ERROR_MESSAGE);			
				
				return;
			}
			
			try {
				fieldGroup.commit();
			} catch (CommitException e) {			
				Notification.show(NotificationMessages.STUDENT_SAVE_VALIDATION_ERROR_TITLE.getString(), 
						NotificationMessages.STUDENT_SAVE_VALIDATION_ERROR_DESCRIPTION.getString(), Type.ERROR_MESSAGE);			
				return;
			}	
			
			addStudentService.saveStudent(student);
			studentSavedLister.studentSaved();
			clearField();
	
			Notification.show(NotificationMessages.STUDENT_SAVE_SUCCESS_TITLE.getString(), 
					NotificationMessages.STUDENT_SAVE_SUCCESS_DESCRIPTION.getString(), Type.WARNING_MESSAGE);
			
		}

		private void clearField() {
			firstName.setValue(null);
			lastName.setValue(null);
			gender.setValue(null);
			age.setValue(null);
			university.setValue(null);
		}
		
		private boolean isSaveOperationValid() {
			return showAllUniversitiesService.getAllUniversities().size() != 0;
		}

		public AddStudentMainLayout load() {

			List<University> universities = showAllUniversitiesService.getAllUniversities();
			university.addItems(universities);
			
			return this;
		}

	}
	
	@Autowired
	private ShowAllUniversitiesService showAllUniversitiesService;
	
	@Autowired
	private AddStudentService addStudentService;

	public Component createComponent(StudentSavedListener studentSavedLister) {
		return new AddStudentMainLayout(studentSavedLister).init().load().bind().layout();
	}
}
