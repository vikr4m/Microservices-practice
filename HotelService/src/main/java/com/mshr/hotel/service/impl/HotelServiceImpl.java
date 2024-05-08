package com.mshr.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mshr.hotel.service.entities.Hotel;
import com.mshr.hotel.service.exceptions.ResourceNotFoundException;
import com.mshr.hotel.service.repositories.HotelRepo;
import com.mshr.hotel.service.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepo hotelRepo;
	
	@Override
	public Hotel create(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		
		Hotel savedHotel = this.hotelRepo.save(hotel);
		return savedHotel;
	}

	@Override
	public List<Hotel> getAll() {
		List<Hotel> allHotel = this.hotelRepo.findAll();
		return allHotel;
	}

	@Override
	public Hotel get(String id) {
		Hotel hotel = this.hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with given id not found"));
		return hotel;
	}

}
