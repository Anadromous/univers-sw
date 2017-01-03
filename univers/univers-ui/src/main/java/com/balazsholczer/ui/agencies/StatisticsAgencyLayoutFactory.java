package com.balazsholczer.ui.agencies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.balazsholczer.model.entity.Agency;
import com.balazsholczer.service.agencystatistics.AgencyStatisticsService;
import com.balazsholczer.service.showallagencies.ShowAllAgenciesService;
import com.balazsholczer.ui.commons.UIComponentBuilder;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class StatisticsAgencyLayoutFactory implements UIComponentBuilder {

	private List<Agency> agencies;
	private StatisticsAgencyLayout statisticsLayout;
	
	@Autowired
	private AgencyStatisticsService agencyStatisticsService;
	
	@Autowired
	private ShowAllAgenciesService showAllAgenciesService;
	
	private class StatisticsAgencyLayout extends VerticalLayout {

		public StatisticsAgencyLayout load() {
			agencies = showAllAgenciesService.getAllAgencies();
			return this;
		}
		
		public StatisticsAgencyLayout layout() {
			
			setMargin(true);
			
			for(Agency agency : agencies) {
				int numOfPatients = agencyStatisticsService.getNumOfPatientsForAgency(agency.getId());
				Label label = new Label("<p><b>"+agency.getAgencyName()+"</b>"+"  -  "+numOfPatients+" student(s)"+"</p>", ContentMode.HTML);
				addComponent(label);
			}
			
			return this;
		}
	}
	
	public void refresh() {
		
		if( statisticsLayout == null ) return;
		statisticsLayout.removeAllComponents();
		statisticsLayout.load();
		statisticsLayout.layout();
	}
	
	public Component createComponent() {
		
		statisticsLayout = new StatisticsAgencyLayout();
		
		return statisticsLayout.load().layout();
	}	
}
