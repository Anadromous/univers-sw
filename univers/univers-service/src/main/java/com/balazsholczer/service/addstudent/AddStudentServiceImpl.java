package com.balazsholczer.service.addstudent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balazsholczer.model.entity.Patient;
import com.balazsholczer.model.entity.Student;
import com.balazsholczer.repository.student.StudentRepository;
import com.balazsholczer.ui.form.PatientForm;

@Service
//@Transactional(readOnly=true)
public class AddStudentServiceImpl implements AddStudentService {
	
	private static final Logger log = LogManager.getLogger(AddStudentServiceImpl.class);

	@Autowired
	private StudentRepository studentRepository;
	
	//@Transactional
	public void saveStudent(PatientForm studentDTO) {
		
		Patient patient = new Patient();
		patient.setFirstName(studentDTO.getFirstName());
		patient.setLastName(studentDTO.getLastName());
		patient.setBirthDate(studentDTO.getBirthDate());
		patient.setGender(studentDTO.getGender());
		patient.setAgency(studentDTO.getAgency());
		patient.getEnrollments().get(0).setHasHealthIns(studentDTO.getHasHealthIns());
		log.debug("Patient: "+patient.toString());
		studentRepository.save(patient);
	}
}
