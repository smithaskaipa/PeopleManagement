package com.peoplemanagement.service;

import com.peoplemanagement.exception.PeopleManagementException;
import com.peoplemanagement.model.Leaves;

public interface LeavesService {

	public boolean addLeaves(Leaves leave) throws PeopleManagementException ;
	
	public boolean validateLeaves(Leaves leave);
	
	public void truncate();
}
