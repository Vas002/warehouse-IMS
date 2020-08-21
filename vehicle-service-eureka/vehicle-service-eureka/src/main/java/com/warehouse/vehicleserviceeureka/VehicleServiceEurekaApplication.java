package com.warehouse.vehicleserviceeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VehicleServiceEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleServiceEurekaApplication.class, args);
	}

}
