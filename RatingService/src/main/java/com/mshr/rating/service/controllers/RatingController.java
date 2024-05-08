package com.mshr.rating.service.controllers;

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

import com.mshr.rating.service.entities.Rating;
import com.mshr.rating.service.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	//create
	@PostMapping
	public ResponseEntity<Rating> createRating (@RequestBody Rating rating){
		Rating createdRating = this.ratingService.create(rating);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
	}
	
	//get
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getUser(@PathVariable String ratingId){
		Rating foundRating= this.ratingService.get(ratingId);
		
		return ResponseEntity.ok(foundRating);
	}
	
	//all users
	@GetMapping
	public ResponseEntity<List<Rating>> getRating(){
		List<Rating> allUsers = this.ratingService.getAll();
		
		return ResponseEntity.ok(allUsers);
	}
	
	//get all rating by userId
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		List<Rating> allUsers = this.ratingService.getByUserId(userId);
		if(allUsers == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(allUsers);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		List<Rating> allUsers = this.ratingService.getByHotelId(hotelId);
		if(allUsers == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(allUsers);
	}
}
