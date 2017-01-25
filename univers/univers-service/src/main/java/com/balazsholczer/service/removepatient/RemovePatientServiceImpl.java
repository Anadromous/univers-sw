package com.balazsholczer.service.removepatient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balazsholczer.model.entity.Patient;
import com.balazsholczer.repository.patient.PatientRepository;

@Service
public class RemovePatientServiceImpl implements RemovePatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	public void removePatient(Patient patient) {
		patientRepository.delete(patient.getId());
	}
}
