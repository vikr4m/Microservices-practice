package com.mshr.user.service.services;

import java.util.List;

import com.mshr.user.service.entities.User;

public interface UserService {
	//user operations
	
	//create user
	User saveUser(User user);
	
	//get all users
	List<User> getAllUsers();

	//get single user
	User getUser(String userId);
	
	//delete user
//	void deleteUser(String userId);
//	
//	//update user
//	User updateUser(User user);
}
