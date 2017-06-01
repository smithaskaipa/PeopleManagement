package com.peoplemanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "contactdetails")
public class ContactDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	long contactdetailsid;

	@Column(name = "contactnumber")
	long contactNumber;

	@Column(name = "alternatecontactnumber")
	long alternateContactNumber;

	@Column(name = "emailid")
	String emailID;

	@ManyToOne
	@JoinColumn(referencedColumnName = "personID")
	Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public long getContactdetailsID() {
		return contactdetailsid;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public long getAlternateContactNumber() {
		return alternateContactNumber;
	}

	public void setAlternateContactNumber(long alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
}
