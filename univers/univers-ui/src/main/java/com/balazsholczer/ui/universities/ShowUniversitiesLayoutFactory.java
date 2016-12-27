package com.balazsholczer.ui.universities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.balazsholczer.model.entity.University;
import com.balazsholczer.service.showalluniversities.ShowAllUniversitiesService;
import com.balazsholczer.ui.commons.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class ShowUniversitiesLayoutFactory implements UIComponentBuilder {

	private List<University> universities;
	private BeanItemContainer<University> container;

	@Autowired
	private ShowAllUniversitiesService showUniversitiesService;

	private class ShowUniversityLayout extends VerticalLayout {

		private Grid universityTable;

		public ShowUniversityLayout init() {

			setMargin(true);
			container = new BeanItemContainer<University>(University.class, universities);

			universityTable = new Grid(container);
			universityTable.setColumnOrder("universityName", "universityCountry", "universityCity");
			universityTable.removeColumn("id");
			universityTable.setImmediate(true);

			return this;
		}

		public ShowUniversityLayout layout() {
			addComponent(universityTable);
			return this;
		}

		public ShowUniversityLayout load() {
			universities = showUniversitiesService.getAllUniversities();
			return this;
		}
	}
	
	public void refreshTable() {
		universities = showUniversitiesService.getAllUniversities();
		container.removeAllItems();
		container.addAll(universities);
	}

	public Component createComponent() {
		return new ShowUniversityLayout().load().init().layout();
	}
}
