package com.example.job_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JobPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobPlatformApplication.class, args);
	}

}
