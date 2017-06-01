package com.peoplemanagement.service;

import com.peoplemanagement.model.Address;

public interface AddressService {

	public void save(Address address);
	void truncate();
	
}
