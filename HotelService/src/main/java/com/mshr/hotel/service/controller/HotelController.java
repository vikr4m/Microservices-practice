package com.mshr.hotel.service.controller;

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

import com.mshr.hotel.service.entities.Hotel;
import com.mshr.hotel.service.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	//create
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel createHotel = this.hotelService.create(hotel);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createHotel);
	}
	
	//get single
	//single user
		@GetMapping("/{id}")
		public ResponseEntity<Hotel> getUser(@PathVariable String id){
			Hotel hotel = this.hotelService.get(id);
			
			return ResponseEntity.ok(hotel);
		}
	
	
	//get all
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(){
		List<Hotel> all = this.hotelService.getAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(all);
	}
}
