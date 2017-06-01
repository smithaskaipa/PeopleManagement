package com.peoplemanagement.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.peoplemanagement.model.ContactDetails;

public interface ContactDetailsRepository  extends CrudRepository<ContactDetails, Serializable>{

}
