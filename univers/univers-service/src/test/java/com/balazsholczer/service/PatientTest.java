package com.balazsholczer.service;

import static org.junit.Assert.fail;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.balazsholczer.model.entity.Agency;
import com.balazsholczer.model.entity.Enrollment;
import com.balazsholczer.model.entity.Patient;
import com.balazsholczer.repository.patient.PatientRepository;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
@SpringBootTest(classes =  SpringBootApplication.class)
@ComponentScan({"com.balazsholczer"})
//@EnableJpaRepositories({"com.balazsholczer"})
//@EntityScan({"com.balazsholczer"})
public class PatientTest {

	private static final Logger log = LogManager.getLogger(PatientTest.class);
	
	@Autowired
	PatientRepository patientRepository;
	
	@Test
	public void test() {
		log.debug("Debugging.............."+patientRepository);
		Patient patient = new Patient();
		patient.setFirstName("John");
		patient.setLastName("Smith");
		patient.setMiddleName("M.");
		patient.setOtherFirstName("JP");
		patient.setOtherLastName("Smith");
		patient.setPatientId("123D");
		patient.setHomeLess(true);
		patient.setStreet("123 W. Stark Street");
		patient.setCity("Portland");
		patient.setState("OR");
		patient.setZip("97229");
		patient.setPhone("503-123-1234");
		patient.setBirthDate(new Date());
		patient.setGender("male");
		patient.setAgency(getAgency());
		//enrollment data
		Enrollment e = new Enrollment();
		e.setPatient(patient);
		e.setEnrollmentDate(new Date());
		e.setHasHealthIns("Yes");
		patient.addEnrollment(e);
		log.debug("Patient: "+patient.toString());
		patientRepository.save(patient);
		fail("Not yet implemented");
	}
	
	private Agency getAgency(){
		Agency a = new Agency();
		a.setId(-1);
		a.setAgencyName("Providence");
		a.setStreet("123 N. Williams");
		a.setCity("Portland");
		a.setState("OR");
		return a;
	}

}
