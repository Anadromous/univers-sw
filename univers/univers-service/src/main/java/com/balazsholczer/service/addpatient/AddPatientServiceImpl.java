package com.balazsholczer.service.addpatient;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balazsholczer.model.entity.Enrollment;
import com.balazsholczer.model.entity.Patient;
import com.balazsholczer.repository.patient.PatientRepository;
import com.balazsholczer.ui.form.PatientForm;

@Service
public class AddPatientServiceImpl implements AddPatientService {
	
	private static final Logger log = LogManager.getLogger(AddPatientServiceImpl.class);

	@Autowired
	private PatientRepository patientRepository;
	
	public void savePatient(PatientForm patientDTO) {
		
		Patient patient = new Patient();
		patient.setFirstName(patientDTO.getFirstName());
		patient.setLastName(patientDTO.getLastName());
		patient.setBirthDate(patientDTO.getBirthDate());
		patient.setGender(patientDTO.getGender());
		patient.setAgency(patientDTO.getAgency());
		if(patient.getEnrollments().size()==0){
			patient.addEnrollment(new Enrollment());
		}
		patient.getEnrollments().get(0).setHasHealthIns(patientDTO.getHasHealthIns());
		log.debug("Patient: "+patient.toString());
		patientRepository.save(patient);
	}
}
