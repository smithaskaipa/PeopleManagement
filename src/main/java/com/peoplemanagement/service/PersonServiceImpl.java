package com.peoplemanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplemanagement.model.Person;
import com.peoplemanagement.repository.PersonRepository;

@Service
@Transactional

public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> getAllPersons() {
		return (List<Person>) this.personRepository.findAll();
	}

	@Override
	public List<Person> findByLastName(String lastName) {
		return (List<Person>) this.personRepository.findByLastName(lastName);
	}

	@Override
	public void save(Person person) {
		this.personRepository.save(person);
		Class.class.getDeclaredFields()[0].getType();

	}

	@Override
	public void truncate() {
		this.personRepository.deleteAll();

	}

}
