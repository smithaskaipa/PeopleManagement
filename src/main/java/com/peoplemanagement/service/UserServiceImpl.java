package com.peoplemanagement.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplemanagement.model.Users;
import com.peoplemanagement.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
    private UserRepository userRepository;
	
	@Override
	public Users findByUserNameAndPassword(String userName, String password) {
		return this.userRepository.findByUserNameAndPassword(userName, password);
	}

	@Override
	public void save(Users user) {
		this.userRepository.save(user);
		
	}

	@Override
	public void truncate() {
		this.userRepository.deleteAll();
		
	}
	

}
