package com.example.zadrestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class ZadRestServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ZadRestServiceApplication.class, args);
	}

}

//"http://127.0.0.1:8080/zadcompanies?withdate=false&nameFilter="