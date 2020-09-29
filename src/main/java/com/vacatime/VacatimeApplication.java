package com.vacatime;

import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class VacatimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacatimeApplication.class, args);
	}

}
