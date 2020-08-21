package com.warehouse.vehiclegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class VehicleGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleGatewayApplication.class, args);
	}

}
