package com.peoplemanagement.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplemanagement.model.Address;
import com.peoplemanagement.repository.AddressRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;	
	@Override
	public void truncate() {
		this.addressRepository.deleteAll();
		
	}
	@Override
	public void save(Address address) {
		this.addressRepository.save(address);		
	}


}
