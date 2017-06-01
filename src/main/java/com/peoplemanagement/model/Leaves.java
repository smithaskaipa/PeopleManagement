package com.peoplemanagement.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Leaves implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	long leavesID;

	@Column(name = "leavetype")
	String leaveType;

	@Column(name = "startdate")
	Date startDate;

	@Column(name = "enddate")
	Date endDate;

	@ManyToOne
	@JoinColumn(referencedColumnName = "personID")
	Person person;

	public long getLeavesID() {
		return leavesID;
	}

	public void setLeavesID(long leavesID) {
		this.leavesID = leavesID;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
