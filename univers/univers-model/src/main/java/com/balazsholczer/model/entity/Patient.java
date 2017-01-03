package com.balazsholczer.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PATIENT")
public class Patient {

	private Integer id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String otherFirstName;
	private String otherLastName;
	private Boolean homeLess;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String zipExt;
	private String county;
	private String phone;
	private Date birthDate;
	private String gender;
	private Agency agency;
	private List<Enrollment> enrollments;

	public Patient() {

	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	//NotNull(message = "Must specify first name!")
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	//NotNull(message = "Must specify last name!")
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the middleName
	 */
	@Column(name = "middle_name")
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "other_first_name")
	public String getOtherFirstName() {
		return otherFirstName;
	}

	public void setOtherFirstName(String otherFirstName) {
		this.otherFirstName = otherFirstName;
	}
	
	@Column(name = "other_last_name")
	public String getOtherLastName() {
		return otherLastName;
	}

	/**
	 * @return the homeLess
	 */
	@Column(name="homeless")
	public Boolean getHomeLess() {
		return homeLess;
	}

	/**
	 * @return the street
	 */
	//NotNull(message = "Street is required")
	@Column(name="street")
	public String getStreet() {
		return street;
	}

	/**
	 * @return the city
	 */
	@Column(name="city")
	public String getCity() {
		return city;
	}

	/**
	 * @return the state
	 */
	@Column(name="state")
	public String getState() {
		return state;
	}

	/**
	 * @return the zip
	 */
	@Column(name="zip")
	public String getZip() {
		return zip;
	}

	/**
	 * @return the zipExt
	 */
	@Column(name="zip_ext")
	public String getZipExt() {
		return zipExt;
	}
	
	/**
	 * @return the county
	 */
	@Column(name="county")
	public String getCounty() {
		return county;
	}

	/**
	 * @return the phone
	 */
	@Column(name="phone")
	public String getPhone() {
		return phone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	public Date getBirthDate() {
		return birthDate;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "agency_id")
	//NotNull(message="Agency must be filled!")
	public Agency getAgency() {
		return agency;
	}
	
	
	/*@Cascade({ CascadeType.SAVE_UPDATE })
	@JoinColumn(name = "enrollment_id")*/
	@OneToMany(mappedBy="patient")
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	//NotNull(message = "Must specify gender!")
	@Column(name = "gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public void setOtherLastName(String otherLastName) {
		this.otherLastName = otherLastName;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Enrollment addEnrollment(Enrollment enrollment) {
		getEnrollments().add(enrollment);
		enrollment.setPatient(this);
		return enrollment;
	}

	public Enrollment removeEnrollment(Enrollment enrollment) {
		getEnrollments().remove(enrollment);
		enrollment.setPatient(null);
		return enrollment;
	}
	@Override
	public String toString() {
		return this.firstName + "-" + this.lastName + "-" + this.birthDate + "-" + this.agency;
	}
}