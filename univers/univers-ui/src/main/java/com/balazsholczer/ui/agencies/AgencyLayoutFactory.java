package com.balazsholczer.ui.agencies;

import org.springframework.beans.factory.annotation.Autowired;

import com.balazsholczer.ui.commons.UniversMainUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name=AgencyLayoutFactory.NAME, ui=UniversMainUI.class )
public class AgencyLayoutFactory extends VerticalLayout implements View, AgencySavedListener {

	public static final String NAME = "operations";
	
	private TabSheet tabSheet;
	
	@Autowired
	private AddAgencyLayoutFactory addAgencyLayoutFactory;
	
	@Autowired
	private ShowAgenciesLayoutFactory showAgenciesLayoutFactory;
	
	@Autowired
	private StatisticsAgencyLayoutFactory statisticsAgencyLayoutFactory;
	
	Component showAllAgenciesTab;
	
	private void addLayout() {
		
		setMargin(true);
		
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		
		Component addAgencyTab = addAgencyLayoutFactory.createComponent(this);
		showAllAgenciesTab = showAgenciesLayoutFactory.createComponent();
		Component showStaticsTab = statisticsAgencyLayoutFactory.createComponent();
		
		tabSheet.addTab(addAgencyTab,"ADD AGENCY");
		tabSheet.addTab(showAllAgenciesTab,"SHOW ALL AGENCIES");
		tabSheet.addTab(showStaticsTab,"STATISTICS");
		
		addComponent(tabSheet);
	}
	
	public void agencySaved() {
		showAgenciesLayoutFactory.refreshTable();
		statisticsAgencyLayoutFactory.refresh();
	}
	
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addLayout();
	}

}
