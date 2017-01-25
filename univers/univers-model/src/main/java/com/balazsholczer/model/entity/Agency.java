package com.balazsholczer.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AGENCY")
public class Agency {

	private Integer id;
	private String agencyName;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String zipExt;
	private String phone;
	private List<Patient> patients = new ArrayList<Patient>();
	
	public Agency() {

	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	/**
	 * @return the agencyName
	 */
	@Column(name = "agency_name")
	public String getAgencyName() {
		return agencyName;
	}

	/**
	 * @return the street
	 */
	@Column(name = "street")
	public String getStreet() {
		return street;
	}

	/**
	 * @return the city
	 */
	@Column(name = "city")
	public String getCity() {
		return city;
	}

	/**
	 * @return the state
	 */
	@Column(name = "state")
	public String getState() {
		return state;
	}

	/**
	 * @return the zip
	 */
	@Column(name = "zip")
	public String getZip() {
		return zip;
	}

	/**
	 * @return the zipExt
	 */
	@Column(name = "zip_ext")
	public String getZipExt() {
		return zipExt;
	}

	/**
	 * @return the phone
	 */
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the patients
	 */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="agency")
	public List<Patient> getPatients() {
		return patients;
	}

	/**
	 * @param patients the patients to set
	 */
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param agencyName the agencyName to set
	 */
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @param zipExt the zipExt to set
	 */
	public void setZipExt(String zipExt) {
		this.zipExt = zipExt;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
