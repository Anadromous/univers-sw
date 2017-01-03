package com.balazsholczer.ui.patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.balazsholczer.ui.commons.UniversMainUI;
import com.balazsholczer.utils.StudentsStringUtils;
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
	private AddPatientMainLayoutFactory mainLayoutFactory;
	
	@Autowired
	private ShowAllPatientsLayoutFactory showStudentsLayoutFactory;
	
	private TabSheet tabSheet;
	
	private void addLayout() {
		
		setMargin(true);
		
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		
		Component addStudentMainTab = mainLayoutFactory.createComponent(this);
	    Component showStudentsTab = showStudentsLayoutFactory.createComponent();
	    
	    tabSheet.addTab(addStudentMainTab, StudentsStringUtils.MAIN_MENU.getString());
	    tabSheet.addTab(showStudentsTab, StudentsStringUtils.SHOW_ALL_STUDENTS.getString());
	    
	    addComponent(tabSheet);
		
	}
	
	public void studentSaved() {
		showStudentsLayoutFactory.refreshTable();
	}
	
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addLayout();
	}
}
