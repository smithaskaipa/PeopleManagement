package com.peoplemanagement.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.peoplemanagement.codetype.RecordStatus;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	long addressID;

	@Column(name = "addressdata")
	String addressData;

	@Column(name = "country")
	String country;

	@ManyToOne
	@JoinColumn(referencedColumnName = "personID")
	Person person;
	
	@Column(name="recordstatus")
	RecordStatus recordStatus;
	
	@Column(name="createddate")
	Date createdDate = new Date();

	public RecordStatus getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(RecordStatus recordStatus) {
		this.recordStatus = recordStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public long getAddressID() {
		return addressID;
	}

	public String getAddressData() {
		return addressData;
	}

	public void setAddressData(String addressData) {
		this.addressData = addressData;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
