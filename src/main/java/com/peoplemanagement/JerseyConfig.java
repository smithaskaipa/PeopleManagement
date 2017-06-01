package com.peoplemanagement;

import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

import com.peoplemanagement.webservice.DummyDataUtility;
import com.peoplemanagement.webservice.PersonWBService;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(PersonWBService.class);
		register(DummyDataUtility.class);
	}

}