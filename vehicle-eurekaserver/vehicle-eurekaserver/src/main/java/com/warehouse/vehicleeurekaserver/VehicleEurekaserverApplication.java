package com.warehouse.vehicleeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class VehicleEurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleEurekaserverApplication.class, args);
	}

}
