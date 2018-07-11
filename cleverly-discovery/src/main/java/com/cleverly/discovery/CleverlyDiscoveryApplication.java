package com.cleverly.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CleverlyDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleverlyDiscoveryApplication.class, args);
	}
}
