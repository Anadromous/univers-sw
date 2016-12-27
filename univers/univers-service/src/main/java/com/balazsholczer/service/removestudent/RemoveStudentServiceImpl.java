package com.balazsholczer.service.removestudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.balazsholczer.model.entity.Student;
import com.balazsholczer.repository.student.StudentRepository;

@Service
public class RemoveStudentServiceImpl implements RemoveStudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public void removeStudent(Student student) {
		studentRepository.delete(student);
	}
}
