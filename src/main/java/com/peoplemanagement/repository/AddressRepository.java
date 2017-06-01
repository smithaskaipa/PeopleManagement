package com.peoplemanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.peoplemanagement.model.Address;

@Repository
@Controller
public interface AddressRepository  extends CrudRepository<Address, Long> {

	
	
}
