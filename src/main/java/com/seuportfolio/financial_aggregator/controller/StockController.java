package com.seuportfolio.financial_aggregator.controller;

import com.seuportfolio.financial_aggregator.dto.StockDto;
import com.seuportfolio.financial_aggregator.model.StockQuote; // <--- Importe a Entidade
import com.seuportfolio.financial_aggregator.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List; // <--- Importe a Lista

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    // Rota 1: Busca a cotação AGORA na Brapi e salva
    @GetMapping("/{ticker}")
    public StockDto getStock(@PathVariable("ticker") String ticker) {
        return stockService.fetchAndSaveQuote(ticker);
    }

    // Rota 2: NOVO! Busca todo o histórico salvo no nosso banco
    @GetMapping("/{ticker}/history")
    public List<StockQuote> getStockHistory(@PathVariable("ticker") String ticker) {
        return stockService.getQuoteHistory(ticker);
    }
}