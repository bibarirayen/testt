package com.projetintegration.projetintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ProjetintegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetintegrationApplication.class, args);
	}

}
