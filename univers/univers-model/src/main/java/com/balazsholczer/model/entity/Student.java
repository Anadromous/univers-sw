package com.balazsholczer.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "STUDENT")
public class Student {

	private Integer id;
	private String firstName;
	private Agency agency;
	private String lastName;
	private Date birthDate;
	private String gender;
	private String hasHealthIns;

	public Student() {

	}
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}
	
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	@Column(name = "gender")
	public String getGender() {
		return gender;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agency_id")
	public Agency getAgency() {
		return agency;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAgeny(Agency agency) {
		this.agency = agency;
	}
	
	/**
	 * @return the hasHealthIns
	 */
	public String getHasHealthIns() {
		return hasHealthIns;
	}

	/**
	 * @param hasHealthIns the hasHealthIns to set
	 */
	public void setHasHealthIns(String hasHealthIns) {
		this.hasHealthIns = hasHealthIns;
	}

	@Override
	public String toString() {
		return this.firstName + "-" + this.lastName + "-" + this.birthDate + "-" + this.hasHealthIns;
	}
}