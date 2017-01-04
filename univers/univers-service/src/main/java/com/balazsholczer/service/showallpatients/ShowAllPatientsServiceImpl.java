package com.balazsholczer.service.showallpatients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balazsholczer.model.entity.Patient;
import com.balazsholczer.repository.patient.PatientRepository;

@Service
public class ShowAllPatientsServiceImpl implements ShowAllPatientsService {

	@Autowired
	private PatientRepository patientRepository;
	
	public List<Patient> getAllPatients() {
		return patientRepository.getAllPatients();
	}
}
