package com.peoplemanagement.service;

import java.util.List;

import com.peoplemanagement.model.Person;

public interface PersonService {

	List<Person> getAllPersons();
	List<Person> findByLastName(String lastname);
    void save(Person person);
    void truncate();
}
