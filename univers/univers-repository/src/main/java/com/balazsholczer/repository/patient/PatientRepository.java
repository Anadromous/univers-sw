package com.balazsholczer.repository.patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.balazsholczer.model.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

	@Query("select s from Patient s order by s.lastName")
	List<Patient> getAllPatients();
	//Patient savePatient(Patient patient);
}
