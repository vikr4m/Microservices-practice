package com.mshr.user.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mshr.user.service.entities.User;
import com.mshr.user.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = this.userService.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
	
	//single user
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId){
		User foundUser = this.userService.getUser(userId);
		
		return ResponseEntity.ok(foundUser);
	}
	
	//all users
	@GetMapping
	public ResponseEntity<List<User>> getUser(){
		List<User> allUsers = this.userService.getAllUsers();
		
		return ResponseEntity.ok(allUsers);
	}
	
	//delete
//	@DeleteMapping("{userId}")
//	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
//		this.userService.deleteUser(null);
//		
//		return ResponseEntity<ApiResponse> new ApiResponse("User deleted successfully",true,HttpStatus.OK);
//	}
	
	//update
}
