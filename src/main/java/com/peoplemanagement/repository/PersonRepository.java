package com.peoplemanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.peoplemanagement.model.Person;

@Repository
@Controller
public interface PersonRepository extends CrudRepository<Person, Long> {
	
	List<Person> findByLastName(String lastname);

}
