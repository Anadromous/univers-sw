package com.balazsholczer.service.agencystatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balazsholczer.repository.agency.AgencyRepository;

@Service
public class AgencyStatisticsServiceImpl implements AgencyStatisticsService {

	@Autowired
	private AgencyRepository universityRepository;
	
	public Integer getNumOfStudentsForUniversity(Integer universityId) {
		return universityRepository.getNumPatientsForAgency(universityId);
	}
}
