/**
 * 
 */
package com.balazsholczer.ui.form;

import java.util.Date;

import com.balazsholczer.model.entity.Agency;

/**
 * @author pchapman
 *
 */
public class PatientForm {

	private Integer id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String otherFirstName;
	private String otherLastName;
	private String patientId;
	private Boolean homeLess;
	private String street;
	private String aptNumber;
	private String city;
	private String state;
	private String zip;
	private String zipExt;
	private String county;
	private String phone;
	private Date birthDate;
	private String gender;
	//EnrollmentData
	private Date enrollmentDate;
	private String hasHealthIns;
	private Boolean referredForEligibility;
	private Double income;
	private Integer householdSize;
	private Agency agency;

	public PatientForm() {

	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @return the otherFirstName
	 */
	public String getOtherFirstName() {
		return otherFirstName;
	}

	/**
	 * @return the otherLastName
	 */
	public String getOtherLastName() {
		return otherLastName;
	}

	/**
	 * @return the homeLess
	 */
	public Boolean getHomeLess() {
		return homeLess;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @return the zipExt
	 */
	public String getZipExt() {
		return zipExt;
	}

	/**
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return the enrollmentDate
	 */
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}

	/**
	 * @return the hasHealthIns
	 */
	public String getHasHealthIns() {
		return hasHealthIns;
	}

	/**
	 * @return the referredForEligibility
	 */
	public Boolean getReferredForEligibility() {
		return referredForEligibility;
	}

	/**
	 * @return the income
	 */
	public Double getIncome() {
		return income;
	}

	/**
	 * @return the householdSize
	 */
	public Integer getHouseholdSize() {
		return householdSize;
	}

	/**
	 * @return the agency
	 */
	public Agency getAgency() {
		return agency;
	}

	/**
	 * @return the patientId
	 */
	public String getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @param otherFirstName the otherFirstName to set
	 */
	public void setOtherFirstName(String otherFirstName) {
		this.otherFirstName = otherFirstName;
	}

	/**
	 * @param otherLastName the otherLastName to set
	 */
	public void setOtherLastName(String otherLastName) {
		this.otherLastName = otherLastName;
	}

	/**
	 * @param homeLess the homeLess to set
	 */
	public void setHomeLess(Boolean homeLess) {
		this.homeLess = homeLess;
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
	 * @param county the county to set
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param enrollmentDate the enrollmentDate to set
	 */
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	/**
	 * @param hasHealthIns the hasHealthIns to set
	 */
	public void setHasHealthIns(String hasHealthIns) {
		this.hasHealthIns = hasHealthIns;
	}

	/**
	 * @param referredForEligibility the referredForEligibility to set
	 */
	public void setReferredForEligibility(Boolean referredForEligibility) {
		this.referredForEligibility = referredForEligibility;
	}

	/**
	 * @param income the income to set
	 */
	public void setIncome(Double income) {
		this.income = income;
	}

	/**
	 * @param householdSize the householdSize to set
	 */
	public void setHouseholdSize(Integer householdSize) {
		this.householdSize = householdSize;
	}

	/**
	 * @param agency the agency to set
	 */
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	
	
}
