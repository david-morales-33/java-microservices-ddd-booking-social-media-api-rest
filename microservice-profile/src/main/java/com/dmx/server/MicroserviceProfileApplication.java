package com.dmx.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProfileApplication.class, args);
	}

}
