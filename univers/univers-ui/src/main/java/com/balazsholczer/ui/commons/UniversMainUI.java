package com.balazsholczer.ui.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.balazsholczer.navigator.UniversNavigator;
import com.balazsholczer.ui.patients.PatientLayoutFactory;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path=UniversMainUI.NAME)
@Title("Screenwise")
@Theme("valo")
public class UniversMainUI extends UI {

	public static final String NAME = "/ui";
	
	private Panel changeTab = new Panel();
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private UniversMenuFactory universMenuFactory;
	
	@Autowired
	private SpringViewProvider viewProvider;
	
	@Autowired
	private UniversLogoLayoutFactory universLogoLayoutFactory;
	
	@Override
	protected void init(VaadinRequest request) {
		
		changeTab.setHeight("100%");
		
		VerticalLayout rootLayout = new VerticalLayout();
		rootLayout.setSizeFull();
		rootLayout.setMargin(true);
		
		Panel contentPanel = new Panel();
		contentPanel.setWidth("95%");
		contentPanel.setHeight("100%");
		
		Panel logoPanel = new Panel();
		logoPanel.addStyleName("v-panel-content");
		logoPanel.setWidth("95%");
		logoPanel.setHeightUndefined();
		
		HorizontalLayout uiLayout = new HorizontalLayout();
		uiLayout.setSizeFull();
		uiLayout.setMargin(false);
		uiLayout.addStyleName("v-panel-content");

		Component logo = universLogoLayoutFactory.createComponent();
		Component menu = universMenuFactory.createComponent();
		
		uiLayout.addComponent(menu);
		uiLayout.addComponent(changeTab);
		
		uiLayout.setComponentAlignment(changeTab, Alignment.TOP_CENTER);
		uiLayout.setComponentAlignment(menu, Alignment.TOP_LEFT);
		
		uiLayout.setExpandRatio(menu, 1);
		uiLayout.setExpandRatio(changeTab, 4);
		
		logoPanel.setContent(logo);
		contentPanel.setContent(uiLayout);
		
		rootLayout.addComponent(logoPanel);
		rootLayout.addComponent(contentPanel);
		rootLayout.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);
		rootLayout.setComponentAlignment(logoPanel, Alignment.TOP_CENTER);
		rootLayout.setExpandRatio(contentPanel, 1);
		
		initNavigator();
		
		setContent(rootLayout);
	}

	private void initNavigator() {
		UniversNavigator navigator = new UniversNavigator(this, changeTab);
		applicationContext.getAutowireCapableBeanFactory().autowireBean(navigator);
		navigator.addProvider(viewProvider);
		navigator.navigateTo(PatientLayoutFactory.NAME);
	}
}
