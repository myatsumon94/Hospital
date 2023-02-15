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
public class Record {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	private String patient_firstname;
	private String patient_lastname;
	
	private String doctor_firstname;
	private String doctor_lastname;
	
	private LocalDate date;
	private String description;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="patient_id")
	private Patient patient;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "appointment_id",updatable=false)
	private Appointment appointment;
	
	public Record() {
		super();
	}


	public Record(String patient_firstname, String patient_lastname, String doctor_firstname, String doctor_lastname,
			LocalDate date, String description, Patient patient, Appointment appointment) {
		super();
		this.patient_firstname = patient_firstname;
		this.patient_lastname = patient_lastname;
		this.doctor_firstname = doctor_firstname;
		this.doctor_lastname = doctor_lastname;
		this.date = date;
		this.description = description;
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



	public String getDoctor_firstname() {
		return doctor_firstname;
	}



	public void setDoctor_firstname(String doctor_firstname) {
		this.doctor_firstname = doctor_firstname;
	}



	public String getDoctor_lastname() {
		return doctor_lastname;
	}



	public void setDoctor_lastname(String doctor_lastname) {
		this.doctor_lastname = doctor_lastname;
	}



	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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
		Record other = (Record) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Record [id=" + id + ", patient_firstname=" + patient_firstname + ", patient_lastname="
				+ patient_lastname + ", doctor_firstname=" + doctor_firstname + ", doctor_lastname=" + doctor_lastname
				+ ", date=" + date + ", description=" + description + "]";
	}



	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
}
