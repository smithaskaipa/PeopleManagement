package com.peoplemanagement.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.peoplemanagement.model.Users;
import com.peoplemanagement.service.UserServiceImpl;

@Path("/users")
public class UserResource {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response validateLogin(Users user) {

		Users userExisting = userServiceImpl.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		if (userExisting != null) {
			return Response.status(Status.OK).entity(userExisting).build();
		}
		return Response.status(Status.UNAUTHORIZED).build();
	}
}
