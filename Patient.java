package com.hospital.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "firstname is required")
	private String firstname;
	
	@NotBlank(message = "lastname is required")
	private String lastname;
	

	private String email;
	

	private String password;
	
	@NotBlank(message = "address is required")
	private String address;
	
	@NotBlank(message = "description is required")
	private String description;
	private String gender;
	private int age;

	private LocalDate start_date;	

	private LocalDate end_date;
	

	@OneToMany(mappedBy = "patient" ,cascade = CascadeType.REFRESH,fetch = FetchType.EAGER,orphanRemoval = true)
	private List<Record> records = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "patient" ,cascade = CascadeType.REFRESH,fetch = FetchType.EAGER,orphanRemoval = true)
	private List<Checkup> checkups = new ArrayList<>();

	
	@OneToMany(mappedBy = "patient" ,cascade = CascadeType.REFRESH,fetch = FetchType.EAGER,orphanRemoval = true)
	private List<Appointment> appointments = new ArrayList<>();
	
	public Patient() {
		super();
	}
	
	



	public Patient(@NotBlank(message = "firstname is required") String firstname,
			@NotBlank(message = "lastname is required") String lastname, String email, String password,
			@NotBlank(message = "address is required") String address,
			@NotBlank(message = "description is required") String description, String gender, int age,
			LocalDate start_date, LocalDate end_date, List<Record> records, List<Checkup> checkups,
			List<Appointment> appointments) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.description = description;
		this.gender = gender;
		this.age = age;
		this.start_date = start_date;
		this.end_date = end_date;
		this.records = records;
		this.checkups = checkups;
		this.appointments = appointments;
	}





	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public List<Checkup> getCheckups() {
		return checkups;
	}





	public void setCheckups(List<Checkup> checkups) {
		this.checkups = checkups;
	}





	public List<Appointment> getAppointments() {
		return appointments;
	}





	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
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
		Patient other = (Patient) obj;
		return Objects.equals(id, other.id);
	}


	public LocalDate getStart_date() {
		return start_date;
	}


	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}


	public LocalDate getEnd_date() {
		return end_date;
	}


	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}


	public List<Record> getRecords() {
		return records;
	}


	public void setRecords(List<Record> records) {
		this.records = records;
	}


	
	
	
	
}
