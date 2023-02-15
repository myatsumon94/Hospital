package com.hospital.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class Checkup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String patient_firstname;
	private String patient_lastname;
	
	private String description;
	private String checkupType;
	private LocalDate checkupDate;	
	private String fees;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="patient_id")
	private Patient patient;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "appointment_id",updatable=false)
	private Appointment appointment;
	
	public Checkup() {
		super();
	}
	
	

	public Checkup(String patient_firstname, String patient_lastname, String description, String checkupType,
			LocalDate checkupDate, String fees, Patient patient, Appointment appointment) {
		super();
		this.patient_firstname = patient_firstname;
		this.patient_lastname = patient_lastname;
		this.description = description;
		this.checkupType = checkupType;
		this.checkupDate = checkupDate;
		this.fees = fees;
		this.patient = patient;
		this.appointment = appointment;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
	public String getPatient_firstname() {
		return patient_firstname;
	}


	public void setPatient_firstname(String patient_firstname) {
		this.patient_firstname = patient_firstname;
	}


	public String getPatient_lastname() {
		return patient_lastname;
	}


	public void setPatient_lastname(String patient_lastname) {
		this.patient_lastname = patient_lastname;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCheckupType() {
		return checkupType;
	}


	public void setCheckupType(String checkupType) {
		this.checkupType = checkupType;
	}


	public LocalDate getCheckupDate() {
		return checkupDate;
	}


	public void setCheckupDate(LocalDate checkupDate) {
		this.checkupDate = checkupDate;
	}


	public String getFees() {
		return fees;
	}


	public void setFees(String fees) {
		this.fees = fees;
	}

	

	public Patient getPatient() {
		return patient;
	}





	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	



	public Appointment getAppointment() {
		return appointment;
	}



	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Checkup other = (Checkup) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Checkup [id=" + id + ", patient_firstname=" + patient_firstname + ", patient_lastname="
				+ patient_lastname + ", description=" + description + ", checkupType=" + checkupType + ", checkupDate="
				+ checkupDate + ", fees=" + fees + "]";
	}



	

	
	
}
