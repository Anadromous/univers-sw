package com.balazsholczer.ui.patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.balazsholczer.ui.commons.UniversMainUI;
import com.balazsholczer.utils.PatientStringUtils;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name=PatientLayoutFactory.NAME, ui=UniversMainUI.class)
public class PatientLayoutFactory extends VerticalLayout implements View, PatientSavedListener {

	public static final String NAME = "addpatient";

	@Autowired
	private AddPatientMainLayoutFactory addPatientMainLayoutFactory;
	
	@Autowired
	private ShowAllPatientsLayoutFactory showAllPatientsLayoutFactory;
	
	private TabSheet tabSheet;
	
	private void addLayout() {
		
		setMargin(true);
		
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		
		Component addStudentMainTab = addPatientMainLayoutFactory.createComponent(this);
	    Component showStudentsTab = showAllPatientsLayoutFactory.createComponent();
	    
	    tabSheet.addTab(addStudentMainTab, PatientStringUtils.MAIN_MENU.getString());
	    tabSheet.addTab(showStudentsTab, PatientStringUtils.SHOW_ALL_STUDENTS.getString());
	    
	    addComponent(tabSheet);
		
	}
	
	public void studentSaved() {
		showAllPatientsLayoutFactory.refreshTable();
	}
	
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addLayout();
	}
}
