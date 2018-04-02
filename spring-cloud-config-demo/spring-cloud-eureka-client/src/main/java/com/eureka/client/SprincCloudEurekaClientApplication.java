package com.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SprincCloudEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprincCloudEurekaClientApplication.class, args);
	}
}
