package com.example.Candidature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CandidatureApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidatureApplication.class, args);
	}

}
