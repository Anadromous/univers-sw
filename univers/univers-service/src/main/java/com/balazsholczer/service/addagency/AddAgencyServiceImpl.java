package com.balazsholczer.service.addagency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balazsholczer.model.entity.Agency;
import com.balazsholczer.repository.agency.AgencyRepository;

@Service
public class AddAgencyServiceImpl implements AddAgencyService {

	@Autowired
	private AgencyRepository agencyRepository;
	
	public void addAgency(Agency agencyDTO) {
		
		Agency agency = new Agency();
		agency.setAgencyName(agencyDTO.getAgencyName());
		agency.setState(agencyDTO.getState());
		agency.setCity(agencyDTO.getCity());
		
		agencyRepository.save(agency);
	}
}
