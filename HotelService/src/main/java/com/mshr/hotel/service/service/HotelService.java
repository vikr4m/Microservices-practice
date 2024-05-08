package com.mshr.hotel.service.service;

import java.util.List;

import com.mshr.hotel.service.entities.Hotel;

public interface HotelService {
	//create
	Hotel create(Hotel hotel);
	
	//get all
	List<Hotel> getAll();
	
	//get single
	Hotel get(String id);
}
