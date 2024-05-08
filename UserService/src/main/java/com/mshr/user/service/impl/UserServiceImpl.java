package com.mshr.user.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mshr.user.service.entities.Hotel;
import com.mshr.user.service.entities.Rating;
import com.mshr.user.service.entities.User;
import com.mshr.user.service.exceptions.ResourceNotFoundException;
import com.mshr.user.service.external.services.HotelService;
import com.mshr.user.service.repositories.UserRepository;
import com.mshr.user.service.services.UserService;
import com.netflix.discovery.converters.Auto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		// generate unique userId
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return this.userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return this.userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		// get user from db with the help of user repository
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found " + userId));

		// fetch rating of the user from RATING SERVICE
		// http://localhost:8003/ratings/users/{userId}

		Rating[] ratingsOfUser = restTemplate
				.getForObject("http://RATINGSERVICE/ratings/users/" + user.getUserId(), Rating[].class);
		logger.info("{}", ratingsOfUser);

		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		
		List<Rating> ratingList = ratings.stream().map(rating -> {
			// api call to hotel service to get the hotel
			// http://localhost:8082/hotels/10dfaf23-0de4-436d-8162-495e107adb33
//			ResponseEntity<Hotel> forEntity = restTemplate
//					.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			//logger.info("response status code: {}", forEntity.getStatusCode());

			// set the hotel to rating
			rating.setHotel(hotel);

			// return the rating
			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingList);

		return user;
	}

//	@Override
//	public void deleteUser(String userId) {
//		User user = this.userRepo.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found" + userId));
//		this.userRepo.delete(user);
//	}
//
//	@Override
//	public User updateUser(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
