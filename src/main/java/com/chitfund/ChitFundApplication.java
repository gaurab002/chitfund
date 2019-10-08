package com.chitfund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ChitFundApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChitFundApplication.class, args);
	}

}
