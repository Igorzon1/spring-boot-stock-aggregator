package com.seuportfolio.financial_aggregator.scheduler;

import com.seuportfolio.financial_aggregator.service.StockService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // Avisa ao Spring: "Crie e gerencie esse objeto para mim"
public class StockUpdateScheduler {

    private final StockService stockService;

    // Injetamos o Service que já sabe buscar e salvar
    public StockUpdateScheduler(StockService stockService) {
        this.stockService = stockService;
    }

    // fixedRate = 60000 significa que vai rodar a cada 60.000 milissegundos (1 minuto)
    @Scheduled(fixedRate = 60000)
    public void updatePopularStocks() {
        System.out.println("⏳ [Scheduler] Iniciando atualização automática das cotações...");

        // Vamos atualizar duas ações famosas automaticamente
        List<String> tickers = List.of("PETR4", "VALE3");

        for (String ticker : tickers) {
            try {
                stockService.fetchAndSaveQuote(ticker);
            } catch (Exception e) {
                System.out.println("❌ Erro ao buscar cotação de " + ticker + ": " + e.getMessage());
            }
        }

        System.out.println("✅ [Scheduler] Atualização finalizada!");
    }
}