package com.seuportfolio.financial_aggregator.client;

import com.seuportfolio.financial_aggregator.dto.BrapiResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "brapiClient", url = "https://brapi.dev/api")
public interface BrapiClient {

    @GetMapping("/quote/{ticker}")
    BrapiResponseDto getQuote(@PathVariable("ticker") String ticker,
                              @RequestParam("token") String token);
}