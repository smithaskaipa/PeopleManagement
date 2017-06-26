package com.peoplemanagement.webservice;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.peoplemanagement.model.Person;
import com.peoplemanagement.service.PersonService;

@Path("/persons")
public class PersonResource {

	@Autowired
	private PersonService personService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPersons() throws SQLException {
		return personService.getAllPersons();
	}

	@GET
	@Path("/bylastname/{lastname}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> findPersonByLastName(@PathParam("lastname") String lastName) {
		return personService.findByLastName(lastName);
	}

	@POST
	@Path("/registerPerson")
	@Produces(MediaType.APPLICATION_JSON)
	public void registerPerson(Person person) {
		this.personService.save(person);
	}

	public Date getDate(String date) {

		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8, 10));
		DateFormat df = new SimpleDateFormat();
		df.getCalendar().set(year, month - 1, day);
		return df.getCalendar().getTime();

	}
}
