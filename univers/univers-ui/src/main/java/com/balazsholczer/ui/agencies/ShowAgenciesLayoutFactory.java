package com.balazsholczer.ui.agencies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.balazsholczer.model.entity.Agency;
import com.balazsholczer.service.showallagencies.ShowAllAgenciesService;
import com.balazsholczer.ui.commons.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class ShowAgenciesLayoutFactory implements UIComponentBuilder {

	private List<Agency> agencies;
	private BeanItemContainer<Agency> container;

	@Autowired
	private ShowAllAgenciesService showAllAgenciesService;

	private class ShowAgenciesLayout extends VerticalLayout {

		private Grid agencyTable;

		public ShowAgenciesLayout init() {

			setMargin(true);
			container = new BeanItemContainer<Agency>(Agency.class, agencies);

			agencyTable = new Grid(container);
			agencyTable.setColumnOrder("agencyName", "street", "city");
			agencyTable.removeColumn("id");
			agencyTable.setImmediate(true);

			return this;
		}

		public ShowAgenciesLayout layout() {
			addComponent(agencyTable);
			return this;
		}

		public ShowAgenciesLayout load() {
			agencies = showAllAgenciesService.getAllAgencies();
			return this;
		}
	}
	
	public void refreshTable() {
		agencies = showAllAgenciesService.getAllAgencies();
		container.removeAllItems();
		container.addAll(agencies);
	}

	public Component createComponent() {
		return new ShowAgenciesLayout().load().init().layout();
	}
}
