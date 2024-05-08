package com.mshr.rating.service.services;

import java.util.List;

import com.mshr.rating.service.entities.Rating;

public interface RatingService {

	//create
	Rating create(Rating rating);
	
	//get
	Rating get(String ratingId);
	
	//get-all
	List<Rating> getAll();
	
	//get by UserId
	List<Rating> getByUserId(String userId);
	
	//get by hotelId
	List<Rating> getByHotelId(String hotelId);
	
	
}
