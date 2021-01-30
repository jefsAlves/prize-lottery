package com.alvesjefs.player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PrizzeLotteryMsPlayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrizzeLotteryMsPlayerApplication.class, args);
	}

}
