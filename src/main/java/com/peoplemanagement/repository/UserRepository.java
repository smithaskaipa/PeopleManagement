package com.peoplemanagement.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.peoplemanagement.model.Users;

@Repository
@Controller
public interface UserRepository extends CrudRepository<Users, Serializable> {

	public Users findByUserNameAndPassword(String userName, String password);
}
