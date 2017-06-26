package com.peoplemanagement.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.peoplemanagement.codetype.LeaveType;
import com.peoplemanagement.codetype.RecordStatus;

@Entity
public class Leaves implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	long leavesID;

	@Column(name = "leavetype")
	LeaveType leaveType;

	@Column(name = "startdate")
	Date startDate;

	@Column(name = "enddate")
	Date endDate;

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

	public long getLeavesID() {
		return leavesID;
	}

	public void setLeavesID(long leavesID) {
		this.leavesID = leavesID;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
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
