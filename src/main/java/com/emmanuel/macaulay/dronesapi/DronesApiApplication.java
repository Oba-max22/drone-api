package com.emmanuel.macaulay.dronesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DronesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DronesApiApplication.class, args);
	}

}
