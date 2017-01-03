package com.balazsholczer.repository.enrollment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.balazsholczer.model.entity.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {
	
	@Query("select s from Enrollment s")
	List<Enrollment> getAllEnrollments();
}
