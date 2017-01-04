package com.balazsholczer.service.addpatient;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balazsholczer.model.entity.Patient;
import com.balazsholczer.repository.patient.PatientRepository;
import com.balazsholczer.ui.form.PatientForm;

@Service
//@Transactional(readOnly=true)
public class AddPatientServiceImpl implements AddPatientService {
	
	private static final Logger log = LogManager.getLogger(AddPatientServiceImpl.class);

	@Autowired
	private PatientRepository patientRepository;
	
	//@Transactional
	public void savePatient(PatientForm studentDTO) {
		
		Patient patient = new Patient();
		patient.setFirstName(studentDTO.getFirstName());
		patient.setLastName(studentDTO.getLastName());
		patient.setBirthDate(studentDTO.getBirthDate());
		patient.setGender(studentDTO.getGender());
		patient.setAgency(studentDTO.getAgency());
		patient.getEnrollments().get(0).setHasHealthIns(studentDTO.getHasHealthIns());
		log.debug("Patient: "+patient.toString());
		patientRepository.save(patient);
	}
}
