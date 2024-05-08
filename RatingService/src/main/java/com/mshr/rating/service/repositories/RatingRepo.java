package com.mshr.rating.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mshr.rating.service.entities.Rating;

public interface RatingRepo extends JpaRepository<Rating, String>{
	//custom finder method
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
}
