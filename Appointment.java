package com.hospital.entity;

import java.time.LocalDate;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Appointment Date is required.")
	private LocalDate date;

	@NotBlank(message = "Patient FirstName is required.")
	private String patient_firstname;
	@NotBlank(message = "Patient LastName is required.")
	private String patient_lastname;
	
	@NotBlank(message = "Doctor FirstName is required.")
	private String doctor_firstname;
	@NotBlank(message = "Doctor lastName is required.")
	private String doctor_lastname;
	

	@NotBlank(message = "Description is required.")
	private String description;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="patient_id")
	private Patient patient;
	
	@OneToOne(mappedBy = "appointment",cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private Record record;
	
	@OneToOne(mappedBy = "appointment",cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private Checkup checkup;
	
	public Appointment() {
		super();
	}
	
	


	public Appointment(@NotNull(message = "Appointment Date is required.") LocalDate date,
			@NotBlank(message = "Patient FirstName is required.") String patient_firstname,
			@NotBlank(message = "Patient LastName is required.") String patient_lastname,
			@NotBlank(message = "Doctor FirstName is required.") String doctor_firstname,
			@NotBlank(message = "Doctor lastName is required.") String doctor_lastname,
			@NotBlank(message = "Description is required.") String description, Patient patient, Record record,
			Checkup checkup) {
		super();
		this.date = date;
		this.patient_firstname = patient_firstname;
		this.patient_lastname = patient_lastname;
		this.doctor_firstname = doctor_firstname;
		this.doctor_lastname = doctor_lastname;
		this.description = description;
		this.patient = patient;
		this.record = record;
		this.checkup = checkup;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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




	public Patient getPatient() {
		return patient;
	}




	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	


	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}
	
	

	public Checkup getCheckup() {
		return checkup;
	}




	public void setCheckup(Checkup checkup) {
		this.checkup = checkup;
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
		Appointment other = (Appointment) obj;
		return Objects.equals(id, other.id);
	}

	
}

