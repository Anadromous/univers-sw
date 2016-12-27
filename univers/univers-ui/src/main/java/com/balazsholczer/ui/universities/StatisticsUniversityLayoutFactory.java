package com.balazsholczer.ui.universities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.balazsholczer.model.entity.University;
import com.balazsholczer.service.showalluniversities.ShowAllUniversitiesService;
import com.balazsholczer.service.universitystatistics.UniversityStatisticsService;
import com.balazsholczer.ui.commons.UIComponentBuilder;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class StatisticsUniversityLayoutFactory implements UIComponentBuilder {

	private List<University> universities;
	private StatisticsUniversityLayout statisticsLayout;
	
	@Autowired
	private UniversityStatisticsService universityStatisticsService;
	
	@Autowired
	private ShowAllUniversitiesService showAllUniversitiesService;
	
	private class StatisticsUniversityLayout extends VerticalLayout {

		public StatisticsUniversityLayout load() {
			universities = showAllUniversitiesService.getAllUniversities();
			return this;
		}
		
		public StatisticsUniversityLayout layout() {
			
			setMargin(true);
			
			for(University university : universities) {
				int numOfStudents = universityStatisticsService.getNumOfStudentsForUniversity(university.getId());
				Label label = new Label("<p><b>"+university.getUniversityName()+"</b>"+"  -  "+numOfStudents+" student(s)"+"</p>", ContentMode.HTML);
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
		
		statisticsLayout = new StatisticsUniversityLayout();
		
		return statisticsLayout.load().layout();
	}	
}
