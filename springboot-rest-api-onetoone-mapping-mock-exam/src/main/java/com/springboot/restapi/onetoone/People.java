package com.springboot.restapi.onetoone;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="pepole_tbl")
public class People {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
	private String firstname;
	private String lastname;
	Date Dob;
	
	
	@OneToOne(mappedBy="people")
	@JoinColumn(referencedColumnName="id")
	List<Bank> bank;


	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	public Date getDob() {
		return Dob;
	}


	public void setDob(Date dob) {
		Dob = dob;
	}


	public List<Bank> getBank() {
		return bank;
	}


	public void setBank(List<Bank> bank) {
		this.bank = bank;
	}


	public People(String firstname, String lastname, Date dob) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		Dob = dob;
	}


	public People() {
		super();
	}
	
	
	
	

}
