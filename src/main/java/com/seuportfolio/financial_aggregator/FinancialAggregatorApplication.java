package com.seuportfolio.financial_aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class FinancialAggregatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialAggregatorApplication.class, args);
	}

}
