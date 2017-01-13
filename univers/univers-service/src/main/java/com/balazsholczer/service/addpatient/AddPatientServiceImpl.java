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
		patient.setMiddleName(patientDTO.getMiddleName());
		patient.setOtherFirstName(patientDTO.getOtherFirstName());
		patient.setOtherLastName(patientDTO.getOtherLastName());
		patient.setPatientId(patientDTO.getPatientId());
		patient.setHomeLess(patientDTO.getHomeLess());
		patient.setStreet(patientDTO.getStreet());
		patient.setCity(patientDTO.getCity());
		patient.setState(patientDTO.getState());
		patient.setZip(patientDTO.getZip());
		patient.setPhone(patientDTO.getPhone());
		patient.setBirthDate(patientDTO.getBirthDate());
		patient.setGender(patientDTO.getGender());
		patient.setAgency(patientDTO.getAgency());
		//enrollment data
		Enrollment e = new Enrollment();
		e.setPatient(patient);
		e.setEnrollmentDate(patientDTO.getEnrollmentDate());
		e.setHasHealthIns(patientDTO.getHasHealthIns());
		patient.addEnrollment(e);
		log.debug("Patient: "+patient.toString());
		patientRepository.save(patient);
	}
}
