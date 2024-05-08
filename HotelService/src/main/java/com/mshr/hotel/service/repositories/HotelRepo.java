package com.mshr.hotel.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mshr.hotel.service.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String>{

}
