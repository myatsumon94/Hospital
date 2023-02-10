package com.hospital.entity;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@NotNull(message = "Appointment Date is required.")
	private LocalDate date;
	
	@Column(insertable=false, updatable=false)
	private Long patient_id;
	
	@NotBlank(message = "Patient Name is required.")
	private String patientname;
	
	@NotBlank(message = "Doctor Name is required.")
	private String doctorname;
	
	
	@NotBlank(message = "Description is required.")
	private String description;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="patient_id")
//	private Patient patient;
	
	public Appointment() {
		super();
	}
	
	public Appointment(@NotNull(message = "Appointment Date is required.") LocalDate date, Long patient_id,
			@NotBlank(message = "Patient Name is required.") String patientname,
			@NotBlank(message = "Doctor Name is required.") String doctorname,
			@NotBlank(message = "Description is required.") String description) {
		super();
		this.date = date;
		this.patient_id = patient_id;
		this.patientname = patientname;
		this.doctorname = doctorname;
		this.description = description;
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



	public Long getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Long patient_id) {
		this.patient_id = patient_id;
	}

	

	public String getPatientname() {
		return patientname;
	}



	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}



	public String getDoctorname() {
		return doctorname;
	}



	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", date=" + date + ", patient_id=" + patient_id + ", patientname="
				+ patientname + ", doctorname=" + doctorname + ", description=" + description + "]";
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

