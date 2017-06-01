package com.peoplemanagement.service;

import com.peoplemanagement.model.ContactDetails;

public interface ContactDetailsService {

	public void save(ContactDetails contactDetails);
	void truncate();
	
}
