package com.mshr.rating.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mshr.rating.service.entities.Rating;
import com.mshr.rating.service.exceptions.ResourceNotFoundException;
import com.mshr.rating.service.repositories.RatingRepo;
import com.mshr.rating.service.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public Rating create(Rating rating) {
		String randomRatingId = UUID.randomUUID().toString();
		rating.setRatingId(randomRatingId);
		Rating saveRating = this.ratingRepo.save(rating);
		return saveRating;
	}

	@Override
	public Rating get(String ratingId) {
		Rating rating = this.ratingRepo.findById(ratingId)
				.orElseThrow(() -> new ResourceNotFoundException("Rating with given RatingId not found" + ratingId));
		return rating;
	}

	@Override
	public List<Rating> getAll() {
		List<Rating> allRating = this.ratingRepo.findAll();
		return allRating;
	}

	@Override
	public List<Rating> getByUserId(String userId) {
		List<Rating> rating = this.ratingRepo.findByUserId(userId);
		return rating;
		
	}

	@Override
	public List<Rating> getByHotelId(String hotelId) {
		List<Rating> rating = this.ratingRepo.findByHotelId(hotelId);
		return rating;
	}

}
