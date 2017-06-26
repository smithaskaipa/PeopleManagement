package com.peoplemanagement.webservice;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.peoplemanagement.model.Users;
import com.peoplemanagement.service.UserServiceImpl;

@Path("/login")
public class UserResource {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean validateLogin(Users user) {
		Boolean isValidUser = false;

		if (userServiceImpl.findByUserNameAndPassword(user.getUserName(), user.getPassword()) != null) {
			isValidUser = true;
		}
		return isValidUser;
	}
}
