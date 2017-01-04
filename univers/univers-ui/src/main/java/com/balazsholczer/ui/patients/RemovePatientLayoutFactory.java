package com.balazsholczer.ui.patients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.balazsholczer.model.entity.Patient;
import com.balazsholczer.service.removepatient.RemovePatientService;
import com.balazsholczer.service.showallpatients.ShowAllPatientsService;
import com.balazsholczer.ui.commons.UniversMainUI;
import com.balazsholczer.utils.NotificationMessages;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.MultiSelectionModel;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringView(name=RemovePatientLayoutFactory.NAME, ui=UniversMainUI.class)
public class RemovePatientLayoutFactory extends VerticalLayout implements View, Button.ClickListener {

	public static final String NAME = "removepatient";
	private Grid removePatientTable;
	private Button removePatientsButton;
	private List<Patient> patients;

	@Autowired
	private ShowAllPatientsService allPatientsService;
	
	@Autowired
	private RemovePatientService removePatientService;
	
	private void addLayout() {
		
		removePatientsButton = new Button(NotificationMessages.STUDENT_REMOVE_BUTTON.getString());
		
		setMargin(true);
		BeanItemContainer<Patient> container = new BeanItemContainer<Patient>(Patient.class, patients);
		
		removePatientTable = new Grid(container);
		removePatientTable.setColumnOrder("firstName","lastName","age","gender");
		removePatientTable.removeColumn("id");
		removePatientTable.setImmediate(true);
		removePatientTable.setSelectionMode(SelectionMode.MULTI);
		
		removePatientsButton.addClickListener(this);
		removePatientsButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		
		addComponent(removePatientTable);
		addComponent(removePatientsButton);
		
	}
	
	private void loadPatients() {
		patients = allPatientsService.getAllPatients();
	}
	
	public void buttonClick(ClickEvent event) {
		
		MultiSelectionModel selectionModel = (MultiSelectionModel) removePatientTable.getSelectionModel();
		
		for(Object selectedItem : selectionModel.getSelectedRows()) {
			Patient patient = (Patient) selectedItem;
			removePatientTable.getContainerDataSource().removeItem(patient);
			removePatientService.removePatient(patient);
		}
		
		Notification.show(NotificationMessages.STUDENT_REMOVE_SUCCESS_TITLE.getString(), 
				NotificationMessages.STUDENT_REMOVE_SUCCESS_DESCRIPTION.getString(), Type.WARNING_MESSAGE);
		
		removePatientTable.getSelectionModel().reset();
	}

	public void enter(ViewChangeEvent event) {
		
		if( removePatientTable != null ) return;
		
		loadPatients();
		addLayout();
	}
}
