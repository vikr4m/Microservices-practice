package com.mshr.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryHotelratingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryHotelratingApplication.class, args);
	}

}
