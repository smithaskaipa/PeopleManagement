package com.peoplemanagement.exception;

public class PeopleManagementException extends Exception{

	private static final long serialVersionUID = 1L;
    
	String message="UnHandled server exception occured";
	
	public PeopleManagementException(String message){
		super(message);
		this.message = message;
	}
	
}
