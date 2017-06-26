package com.peoplemanagement;

import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

import com.peoplemanagement.webservice.DummyDataUtility;
import com.peoplemanagement.webservice.PersonResource;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(PersonResource.class);
		register(DummyDataUtility.class);
	}

}