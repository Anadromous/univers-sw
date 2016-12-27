package com.balazsholczer.service.addstudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.balazsholczer.model.entity.Student;
import com.balazsholczer.repository.student.StudentRepository;

@Service
//@Transactional(readOnly=true)
public class AddStudentServiceImpl implements AddStudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	//@Transactional
	public void saveStudent(Student studentDTO) {
		
		Student student = new Student();
		student.setFirstName(studentDTO.getFirstName());
		student.setLastName(studentDTO.getLastName());
		student.setAge(studentDTO.getAge());
		student.setGender(studentDTO.getGender());
		student.setUniversity(studentDTO.getUniversity());
		
		studentRepository.save(student);
	}
}
