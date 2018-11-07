package com.sap.hack.your.career.beerrating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BeerratingApplication {

	public static void main(final String[] args) {
		SpringApplication.run(BeerratingApplication.class, args);
	}
}
