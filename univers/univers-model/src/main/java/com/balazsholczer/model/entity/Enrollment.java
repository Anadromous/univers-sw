package com.balazsholczer.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ENROLLMENT")
public class Enrollment {
	
	private Integer id;
	private Patient patient;
	private Date enrollmentDate;
	private String hasHealthIns;
	private Boolean referredForEligibility;
	private Double income;
	private Integer householdSize;
	
	public Enrollment(){
		
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

	@ManyToOne
	@JoinColumn(name="patient_id")
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @return the enrollmentDate
	 */
	//@Type(type="date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="enroll_date")
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}

	/**
	 * @return the hasHealthIns
	 */
	@Column(name="health_ins")
	public String getHasHealthIns() {
		return hasHealthIns;
	}

	/**
	 * @return the referredForEligibility
	 */
	@Column(name="referred")
	public Boolean getReferredForEligibility() {
		return referredForEligibility;
	}

	/**
	 * @return the income
	 */
	@Column(name="income")
	public Double getIncome() {
		return income;
	}

	/**
	 * @return the householdSize
	 */
	@Column(name="household_size")
	public Integer getHouseholdSize() {
		return householdSize;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
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

	@Override
	public String toString() {
		return "Enrollment [enrollmentDate=" + enrollmentDate + ", hasHealthIns="
				+ hasHealthIns + ", referredForEligibility=" + referredForEligibility + ", income=" + income
				+ ", householdSize=" + householdSize + "]";
	}
	
	

}
