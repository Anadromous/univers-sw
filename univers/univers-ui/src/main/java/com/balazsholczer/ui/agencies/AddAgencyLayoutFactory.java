package com.balazsholczer.ui.agencies;

import org.springframework.beans.factory.annotation.Autowired;

import com.balazsholczer.model.entity.Agency;
import com.balazsholczer.service.addagency.AddAgencyService;
import com.balazsholczer.utils.NotificationMessages;
import com.balazsholczer.utils.StudentsStringUtils;
import com.balazsholczer.utils.UniversityStringUtils;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class AddAgencyLayoutFactory {

	@Autowired
	private AddAgencyService addAgencyService;
	
	private class AddAgencyLayout extends VerticalLayout implements Button.ClickListener {

		private TextField agencyName;
		private TextField agencyCountry;
		private TextField agencyCity;
		private Button saveButton;
		private Agency agency;
		private BeanFieldGroup<Agency> fieldGroup;
		private AgencySavedListener agencySavedListener;
		
		public AddAgencyLayout(AgencySavedListener agencySavedListener) {
				this.agencySavedListener = agencySavedListener;
		}
		
		public AddAgencyLayout init() {

			agency = new Agency();
			
			agencyName = new TextField(UniversityStringUtils.UNIVERSITY_NAME.getString());
			agencyCountry = new TextField(UniversityStringUtils.UNIVERSITY_COUNTRY.getString());
			agencyCity = new TextField(UniversityStringUtils.UNIVERSITY_CITY.getString());

			saveButton = new Button(StudentsStringUtils.SAVE_BUTTON.getString(), this);
			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);

			agencyName.setNullRepresentation("");
			agencyCountry.setNullRepresentation("");
			agencyCity.setNullRepresentation("");

			return this;
		}

		public AddAgencyLayout bind() {

			fieldGroup = new BeanFieldGroup<Agency>(Agency.class);
			fieldGroup.bindMemberFields(this);
			fieldGroup.setItemDataSource(agency);
			
			return this;
		}
		
		public Component layout() {
			
			setWidth("100%");
			
			GridLayout grid = new GridLayout(1,4);
			grid.setHeightUndefined();
			grid.setSpacing(true);
			
			grid.addComponent(agencyName, 0, 0);
			grid.addComponent(agencyCountry, 0, 1);
			grid.addComponent(agencyCity, 0, 2);
			grid.addComponent(saveButton, 0, 3);

			return grid;
		}

		public void buttonClick(ClickEvent event) {
			
			try {
				fieldGroup.commit();
			} catch (CommitException e) {
				Notification.show(NotificationMessages.UNIVERSITY_SAVED_VALIDATION_ERROR_TITLE.getString(),
						NotificationMessages.UNIVERSITY_SAVED_VALIDATION_ERROR_DESCRIPTION.getString(), Type.ERROR_MESSAGE);
				return;
			}
			
			clearFields();
			addAgencyService.addAgency(agency);
			agencySavedListener.agencySaved();
			Notification.show(NotificationMessages.UNIVERSITY_SAVE_SUCCESS_TITLE.getString(),
					NotificationMessages.UNIVERSITY_SAVE_SUCCESS_DESCRIPTION.getString(), Type.WARNING_MESSAGE);
		}

		private void clearFields() {
			agencyName.setValue(null);
			agencyCountry.setValue(null);
			agencyCity.setValue(null);
		}

	}

	public Component createComponent(AgencySavedListener agencySavedListener) {
		return new AddAgencyLayout(agencySavedListener).init().bind().layout();
	}
}
