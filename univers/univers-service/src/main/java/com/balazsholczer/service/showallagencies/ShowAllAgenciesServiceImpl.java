package com.balazsholczer.service.showallagencies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balazsholczer.model.entity.Agency;
import com.balazsholczer.repository.agency.AgencyRepository;

@Service
public class ShowAllAgenciesServiceImpl implements ShowAllAgenciesService {

	@Autowired
	private AgencyRepository agencyRepository;
	
	public List<Agency> getAllAgencies() {
		return agencyRepository.getAllAgencies();
	}
}
