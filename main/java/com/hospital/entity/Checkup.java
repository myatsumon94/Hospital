package com.hospital.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Checkup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String checkupType;

	private LocalDate checkupDate;
	
	private String fees;

	
	public Checkup() {
		super();
	}


	

	public Checkup(String checkupType, LocalDate checkupDate, String fees) {
		super();
		this.checkupType = checkupType;
		this.checkupDate = checkupDate;
		this.fees = fees;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
	
	
	
}
