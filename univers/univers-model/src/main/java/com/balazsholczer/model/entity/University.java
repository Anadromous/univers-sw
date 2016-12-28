package com.balazsholczer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UNIVERSITY")
public class University {

	private Integer id;
	private String universityName;
	private String universityCountry;
	private String universityCity;

	public University() {

	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	@Column(name = "university_name")
	public String getUniversityName() {
		return universityName;
	}
	
	@Column(name = "university_city")
	public String getUniversityCity() {
		return universityCity;
	}

	@Column(name = "university_country")
	public String getUniversityCountry() {
		return universityCountry;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public void setUniversityCountry(String universityCountry) {
		this.universityCountry = universityCountry;
	}

	public void setUniversityCity(String universityCity) {
		this.universityCity = universityCity;
	}

	@Override
	public String toString() {
		return this.universityName;
	}
}
