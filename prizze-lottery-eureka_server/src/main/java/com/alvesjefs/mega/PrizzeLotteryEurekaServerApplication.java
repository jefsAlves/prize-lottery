package com.alvesjefs.mega;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PrizzeLotteryEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrizzeLotteryEurekaServerApplication.class, args);
	}

}
