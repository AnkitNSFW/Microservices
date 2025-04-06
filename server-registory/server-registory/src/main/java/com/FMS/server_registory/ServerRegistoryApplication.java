package com.FMS.server_registory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerRegistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerRegistoryApplication.class, args);
	}

}
