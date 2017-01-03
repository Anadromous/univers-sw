package com.balazsholczer.service.removepatient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balazsholczer.model.entity.Patient;
import com.balazsholczer.model.entity.Student;
import com.balazsholczer.repository.patient.PatientRepository;

@Service
public class RemovePatientServiceImpl implements RemovePatientService {

	@Autowired
	private PatientRepository studentRepository;
	
	public void removePatient(Patient patient) {
		studentRepository.delete(patient);
	}
}
