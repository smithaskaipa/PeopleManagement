package com.peoplemanagement.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplemanagement.model.ContactDetails;
import com.peoplemanagement.repository.ContactDetailsRepository;

@Service
@Transactional
public class ContactDetailsServiceImpl implements ContactDetailsService {

	@Autowired
	private ContactDetailsRepository contactDetailsRepository;	
	@Override
	public void truncate() {
		this.contactDetailsRepository.deleteAll();
		
	}
	
	@Override
	public void save(ContactDetails contactDetails) {
		this.contactDetailsRepository.save(contactDetails);	
		
	}
}
