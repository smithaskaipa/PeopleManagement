package com.peoplemanagement.webservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.peoplemanagement.PMSpringController;
import com.peoplemanagement.codetype.RecordStatus;
import com.peoplemanagement.model.Address;
import com.peoplemanagement.model.ContactDetails;
import com.peoplemanagement.model.Person;
import com.peoplemanagement.model.Users;
import com.peoplemanagement.service.AddressService;
import com.peoplemanagement.service.ContactDetailsService;
import com.peoplemanagement.service.PersonService;
import com.peoplemanagement.service.UserService;

@Path("/DemoData")
@Component
public class DummyDataUtility {

	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PMSpringController.class);

	String[] personFirstNames = { "Zoe", "Isaac", "Owen", "Thomas", "Gabrielle", "Gavin", "Karen", "Mary", "Claire",
			"Olivia" };
	String[] personMiddleNames = { "Hill", "Black", "Martin", "Suther", "Gallileo", "Newton", "Robert", "Bale", "Bond",
			"Joker" };
	String[] personLastNames = { "River", "White", "Smith", "Venkat", "Mark", "Isaac", "Vadra", "Gandhi", "Modi",
			"Trumph" };

	String[] addressDatas = { "Bengaluru,Karnataka,India", "Mylapore,Chennai,TamilNandu",
			"Jubli Hills,Hyderbad,AndraPradesh", "Bengaluru,Karnataka,India", "Mylapore,Chennai,TamilNandu",
			"Jubli Hills,Hyderbad,AndraPradesh", "Bengaluru,Karnataka,India", "Mylapore,Chennai,TamilNandu",
			"Jubli Hills,Hyderbad,AndraPradesh", "Bengaluru,Karnataka,India" };

	String[] contactNumberDetails = { "546546546546", "789354133", "9638527410", "546546546546", "789354133",
			"9638527410", "546546546546", "789354133", "9638527410", "546546546546" };
	String[] alternateNumberDetails = { "546546546546", "789354133", "9638527410", "546546546546", "789354133",
			"9638527410", "546546546546", "789354133", "9638527410", "546546546546" };

	String[] emailIDs = { "xyz@gmail.com", "abc@gmail.com", "lmn@gmail.com", "xyz@gmail.com", "abc@gmail.com",
			"lmn@gmail.com", "xyz@gmail.com", "abc@gmail.com", "lmn@gmail.com", "xyz@gmail.com" };

	@Autowired
	private AddressService addressService;

	@Autowired
	private ContactDetailsService contactDetailsService;

	@Autowired
	private UserService userService;

	@Autowired
	private PersonService personService;

	@POST
	@Path("/insertDummyData")
	@Produces(MediaType.APPLICATION_JSON)
	public void insertDummyData() {
		List<Person> personIDs = insertPersonRecords();
		insertAddress(personIDs);
		insertContactDetails(personIDs);
		insertUserDetails(personIDs);
	}

	@DELETE
	@Path("/resetDatabase")
	public void resetDatabase() {
		this.addressService.truncate();
		this.userService.truncate();
		this.personService.truncate();
	}

	public List<Person> insertPersonRecords() {
		List<Person> personIDs = new ArrayList<Person>();
		Person person = null;
		for (int i = 0; i < personFirstNames.length; i++) {
			person = new Person();
			person.setFirstName(personFirstNames[i]);
			person.setMiddleName(personMiddleNames[i]);
			person.setLastName(personLastNames[i]);
			person.setCaste("GM");
			person.setDateOfBirth(new Date());
			person.setGender("Male");
			person.setNationality("Indian");
			person.setMaritalStatus("Married");
			person.setRecordStatus(RecordStatus.Active);
			this.personService.save(person);
			personIDs.add(person);
		}

		return personIDs;
	}

	public void insertAddress(List<Person> personIDs) {

		Address address = null;

		for (int i = 0; i < personIDs.size(); i++) {
			address = new Address();
			address.setAddressData(addressDatas[i]);
			address.setCountry("India");
			address.setPerson(personIDs.get(i));
			this.addressService.save(address);
		}

	}

	public void insertContactDetails(List<Person> personIDs) {

		ContactDetails contactDetails = null;

		for (int i = 0; i < personIDs.size(); i++) {
			contactDetails = new ContactDetails();
			contactDetails.setContactNumber(988);
			contactDetails.setAlternateContactNumber(1234);
			contactDetails.setEmailID(emailIDs[i]);
			contactDetails.setPerson(personIDs.get(i));
			this.contactDetailsService.save(contactDetails);
		}

	}

	public void insertUserDetails(List<Person> personIDs) {

		Users user = null;

		for (int i = 0; i < personIDs.size(); i++) {
			user = new Users();
			user.setPassword("password");
			user.setUserName(personFirstNames[i]);
			user.setPerson(personIDs.get(i));
			this.userService.save(user);
		}

	}
}
