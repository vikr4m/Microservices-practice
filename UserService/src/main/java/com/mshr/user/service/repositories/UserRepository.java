package com.mshr.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mshr.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}
