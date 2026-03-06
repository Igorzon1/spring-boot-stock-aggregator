package com.seuportfolio.financial_aggregator.controller;

import com.seuportfolio.financial_aggregator.dto.StockDto;
import com.seuportfolio.financial_aggregator.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final StockService stockService;

    // Agora o Controller conversa apenas com o Service
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{ticker}")
    public StockDto getStock(@PathVariable("ticker") String ticker) {
        // O Service cuida de buscar e salvar. O Controller só entrega a resposta.
        return stockService.fetchAndSaveQuote(ticker);
    }
}