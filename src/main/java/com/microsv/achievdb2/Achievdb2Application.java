package com.microsv.achievdb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Achievdb2Application {

	public static void main(String[] args) {
		SpringApplication.run(Achievdb2Application.class, args);
	}

}
