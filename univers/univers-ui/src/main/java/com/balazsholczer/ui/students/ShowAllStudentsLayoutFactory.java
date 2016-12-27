package com.balazsholczer.ui.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.balazsholczer.model.entity.Student;
import com.balazsholczer.service.showallstudents.ShowAllStudentsService;
import com.balazsholczer.ui.commons.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class ShowAllStudentsLayoutFactory implements UIComponentBuilder {

	private List<Student> students;
	private BeanItemContainer<Student> container;
	
	private class ShawAllStudentsLayout extends VerticalLayout {
		
		private Grid studentsTable;
		
		public ShawAllStudentsLayout init() {
			
			setMargin(true);
			
			container = new BeanItemContainer<Student>(Student.class, students);
			
			studentsTable = new Grid(container);
			studentsTable.setColumnOrder("firstName","lastName","age","gender");
			studentsTable.removeColumn("id");
			studentsTable.removeColumn("university");
			studentsTable.setImmediate(true);
			
			return this;
		}
		
		public ShawAllStudentsLayout load() {
			students = showAllStudentsService.getAllStudents();
			return this;
		}
		
		public ShawAllStudentsLayout layout() {
			addComponent(studentsTable);
			return this;
		}
		
	}
	
	public void refreshTable() {
		students = showAllStudentsService.getAllStudents();
		container.removeAllItems();
		container.addAll(students);
		
	}
	
	@Autowired
	private ShowAllStudentsService showAllStudentsService;
	
	public Component createComponent() {
		return new ShawAllStudentsLayout().load().init().layout();
	}

	
}
