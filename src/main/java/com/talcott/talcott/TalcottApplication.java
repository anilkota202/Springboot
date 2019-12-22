package com.talcott.talcott;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.talcott.* ")
public class TalcottApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalcottApplication.class, args);
	}

}
