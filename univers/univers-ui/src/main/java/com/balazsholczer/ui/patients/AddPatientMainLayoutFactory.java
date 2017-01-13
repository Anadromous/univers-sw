package com.balazsholczer.ui.patients;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.balazsholczer.model.entity.Agency;
import com.balazsholczer.service.addpatient.AddPatientService;
import com.balazsholczer.service.showallagencies.ShowAllAgenciesService;
import com.balazsholczer.ui.form.PatientForm;
import com.balazsholczer.utils.Gender;
import com.balazsholczer.utils.NotificationMessages;
import com.balazsholczer.utils.PatientStringUtils;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class AddPatientMainLayoutFactory {

	private static final Logger log = LogManager.getLogger(AddPatientMainLayoutFactory.class);
	
	private class AddPatientMainLayout extends FormLayout implements Button.ClickListener {

		private TextField firstName;
		private TextField lastName;
		private TextField middleName;
		private TextField otherFirstName;
		private TextField otherLastName;
		private TextField patientId;		
		private DateField birthDate;
		private CheckBox homeLess;
		private TextField street;
		private TextField aptNumber;
		private TextField city;
		private ComboBox state;
		private TextField zip;
		private TextField phone;
		private ComboBox county;
		private OptionGroup gender;
		private ComboBox agency;
		//enrollment
		private DateField enrollmentDate;
		private OptionGroup hasHealthIns;
		
		private Button saveButton;
		private Button clearButton;
		

		private BeanFieldGroup<PatientForm> fieldGroup;
		private PatientForm patient;
		
		private PatientSavedListener studentSavedLister;
		
		public AddPatientMainLayout(PatientSavedListener patientSavedLister) {
			this.studentSavedLister = patientSavedLister;
		}

		public AddPatientMainLayout init() {

			fieldGroup = new BeanFieldGroup<PatientForm>(PatientForm.class);
			patient = new PatientForm();
			

			firstName = new TextField(PatientStringUtils.FIRST_NAME.getString());
			lastName = new TextField(PatientStringUtils.LAST_NAME.getString());
			middleName = new TextField("Middle");
			otherFirstName = new TextField("Other First Name");
			otherLastName = new TextField("Other Last Name");
			street = new TextField("Street");
			aptNumber = new TextField("Apt.#");
			city = new TextField("City");
			state = new ComboBox("State");
			state.addItem("OR");
			state.addItem("WA");
			state.setValue("OR");
			zip = new TextField("Zip");
			county = new ComboBox("County");
			county.addItem("Multnomah");
			county.addItem("Washington");
			phone = new TextField("Phone");
			birthDate = new DateField(PatientStringUtils.AGE.getString());
			homeLess = new CheckBox("Homeless or unstable housing? (If so, check box and only write ZIP code and county below)");
			enrollmentDate = new DateField("Enrollment Date");
			patientId = new TextField("Patient ID");
			gender = new OptionGroup(PatientStringUtils.GENDER.getString());
			gender.addStyleName("horizontal");
			gender.addItems(Gender.MALE.getString(),Gender.FEMALE.getString());
			hasHealthIns = new OptionGroup("Do you have health insurance or Medicaid?");
			hasHealthIns.setMultiSelect(false);
			hasHealthIns.addItems("Yes", "Yes, but not enough to cover my needs", "No");
			saveButton = new Button(PatientStringUtils.SAVE_BUTTON.getString());
			clearButton = new Button(PatientStringUtils.CLEAR_BUTTON.getString());
			
			agency = new ComboBox(PatientStringUtils.UNIVERSITY.getString());
			agency.setWidth("100%");
			
			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);

			saveButton.addClickListener(this);
			clearButton.addClickListener(this);
			
			firstName.setNullRepresentation("");
			lastName.setNullRepresentation("");
			street.setNullRepresentation("");
			city.setNullRepresentation("");
			phone.setNullRepresentation("");
			zip.setNullRepresentation("");
			patientId.setNullRepresentation("");
			otherFirstName.setNullRepresentation("");
			otherLastName.setNullRepresentation("");
			
			return this;
		}

		public AddPatientMainLayout bind() {
			fieldGroup.bindMemberFields(this);
			fieldGroup.setItemDataSource(patient);
			return this;
		}

		public Component layout() {

			final Embedded header = new Embedded();
			setMargin(true);
			GridLayout gridLayout = new GridLayout(5, 9);
			gridLayout.setSizeUndefined();
			gridLayout.setSpacing(true);
			header.setSource(new ThemeResource("../../images/form_header.PNG"));
			header.setSizeFull();
			gridLayout.addComponent(new HorizontalLayout(header), 0, 0, 4, 0);
			//row 1
			gridLayout.addComponent(firstName, 0, 1);
			gridLayout.addComponent(lastName, 1, 1);
			gridLayout.addComponent(middleName, 2, 1);
			gridLayout.addComponent(birthDate, 3, 1);
			//row2
			gridLayout.addComponent(agency, 0, 2, 1, 2);
			gridLayout.addComponent(patientId, 2,2);
			gridLayout.addComponent(enrollmentDate, 3, 2);
			//row3
			gridLayout.addComponent(homeLess, 0, 3, 3, 3);
			//row4
			gridLayout.addComponent(street, 0,4,2,4);
			gridLayout.addComponent(aptNumber, 3,4);
			//row5
			gridLayout.addComponent(city,0,5);
			gridLayout.addComponent(state,1,5);
			gridLayout.addComponent(zip,2,5);
			gridLayout.addComponent(county,3,5);
			//row6
			gridLayout.addComponent(phone,0,6);
			gridLayout.addComponent(otherFirstName,1,6);
			gridLayout.addComponent(otherLastName, 2, 6);
			//row7
			gridLayout.addComponent(gender, 0, 7);
			gridLayout.addComponent(hasHealthIns, 1, 7, 2, 7);

			gridLayout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 8);

			return gridLayout;
		}
		
		public Component layoutForm() {

			FormLayout gridLayout = new FormLayout();
			setMargin(true);
			gridLayout.setSizeUndefined();
			gridLayout.setSpacing(true);

			gridLayout.addComponent(firstName);
			gridLayout.addComponent(lastName);

			gridLayout.addComponent(birthDate);
			gridLayout.addComponent(gender);
			
			gridLayout.addComponent(agency);
			
			gridLayout.addComponent(hasHealthIns);

			gridLayout.addComponent(new HorizontalLayout(saveButton, clearButton));

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
			
			addPatientService.savePatient(patient);
			studentSavedLister.studentSaved();
			clearField();
	
			Notification.show(NotificationMessages.STUDENT_SAVE_SUCCESS_TITLE.getString(), 
					NotificationMessages.STUDENT_SAVE_SUCCESS_DESCRIPTION.getString(), Type.WARNING_MESSAGE);
			
		}

		private void clearField() {
			firstName.setValue(null);
			lastName.setValue(null);
			gender.setValue(null);
			birthDate.setValue(null);
			agency.setValue(null);
		}
		
		private boolean isSaveOperationValid() {
			return true;//showAllUniversitiesService.getAllUniversities().size() != 0;
		}

		public AddPatientMainLayout load() {

			List<Agency> agencies = showAllAgenciesService.getAllAgencies();
			log.debug("Getting clinics: "+agencies.size());
			agency.addItems(agencies);
			
			return this;
		}

	}
	
	@Autowired
	private ShowAllAgenciesService showAllAgenciesService;
	
	@Autowired
	private AddPatientService addPatientService;

	public Component createComponent(PatientSavedListener studentSavedLister) {
		return new AddPatientMainLayout(studentSavedLister).init().load().bind().layout();
	}
}
