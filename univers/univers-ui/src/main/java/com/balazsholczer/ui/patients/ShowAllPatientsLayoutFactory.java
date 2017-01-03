package com.balazsholczer.ui.patients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.balazsholczer.model.entity.Patient;
import com.balazsholczer.service.showallpatients.ShowAllPatientsService;
import com.balazsholczer.ui.commons.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class ShowAllPatientsLayoutFactory implements UIComponentBuilder {

	private List<Patient> patients;
	private BeanItemContainer<Patient> container;
	
	private class ShowAllPatientsLayout extends VerticalLayout {
		
		private Grid patientsTable;
		
		public ShowAllPatientsLayout init() {
			
			setMargin(true);
			
			container = new BeanItemContainer<Patient>(Patient.class, patients);
			
			patientsTable = new Grid(container);
			patientsTable.setColumnOrder("firstName","lastName","city","state");
			patientsTable.removeColumn("id");
			patientsTable.removeColumn("agency");
			patientsTable.setImmediate(true);
			
			return this;
		}
		
		public ShowAllPatientsLayout load() {
			patients = showAllPatientsService.getAllPatients();
			return this;
		}
		
		public ShowAllPatientsLayout layout() {
			addComponent(patientsTable);
			return this;
		}
		
	}
	
	public void refreshTable() {
		patients = showAllPatientsService.getAllPatients();
		container.removeAllItems();
		container.addAll(patients);
		
	}
	
	@Autowired
	private ShowAllPatientsService showAllPatientsService;
	
	public Component createComponent() {
		return new ShowAllPatientsLayout().load().init().layout();
	}

	
}
