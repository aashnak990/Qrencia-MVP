package com.qrencia.competitions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CompetitionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompetitionsApplication.class, args);
	}

}
