package com.seuportfolio.financial_aggregator.service;

import com.seuportfolio.financial_aggregator.client.BrapiClient;
import com.seuportfolio.financial_aggregator.dto.BrapiResponseDto;
import com.seuportfolio.financial_aggregator.dto.StockDto;
import com.seuportfolio.financial_aggregator.model.StockQuote;
import com.seuportfolio.financial_aggregator.repository.StockQuoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service // Avisa ao Spring que esta é a classe de regras de negócio
public class StockService {

    private final BrapiClient brapiClient;
    private final StockQuoteRepository repository;

    // Injetamos as duas ferramentas que o Service precisa para trabalhar
    public StockService(BrapiClient brapiClient, StockQuoteRepository repository) {
        this.brapiClient = brapiClient;
        this.repository = repository;
    }

    public StockDto fetchAndSaveQuote(String ticker) {
        // 1. Busca na API externa
        // Lembre-se de colocar o seu token real aqui!
        BrapiResponseDto response = brapiClient.getQuote(ticker, "SEU_TOKEN_AQUI");

        // Pega o primeiro item da lista de resultados
        StockDto stockData = response.results().get(0);

        // 2. Transforma o DTO em uma Entidade para salvar no banco
        StockQuote quoteToSave = new StockQuote(
                stockData.symbol(),
                stockData.regularMarketPrice(),
                LocalDateTime.now() // Pega a data e hora de agora
        );

        // 3. Salva no banco de dados!
        repository.save(quoteToSave);
        System.out.println("Salvo no banco com sucesso: " + quoteToSave.getSymbol());

        // 4. Devolve o dado para o Controller
        return stockData;
    }
}