package com.sms.sms_discovery_sever_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SmsDiscoverySeverServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsDiscoverySeverServiceApplication.class, args);
	}

}
