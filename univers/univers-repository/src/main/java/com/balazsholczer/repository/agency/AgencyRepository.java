package com.balazsholczer.repository.agency;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.balazsholczer.model.entity.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Integer> {

	@Query("select u from Agency u order by u.agencyName")
	List<Agency> getAllAgencies();
	
	@Query("select count(s) from Patient s where s.agency.id =:agencyId")
	Integer getNumPatientsForAgency(@Param("agencyId") Integer agencyId);
}
