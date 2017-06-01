package com.peoplemanagement.service;

import com.peoplemanagement.model.Users;

public interface UserService {
 
	public Users findByUserNameAndPassword(String userName, String password);
	public void save(Users user);
    public void truncate();	
}
