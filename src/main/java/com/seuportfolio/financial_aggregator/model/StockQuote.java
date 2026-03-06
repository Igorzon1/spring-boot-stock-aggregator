package com.seuportfolio.financial_aggregator.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Avisa ao Spring: "Crie uma tabela no banco para esta classe"
@Table(name = "tb_stock_quotes")
public class StockQuote {

    @Id // Diz que este é o identificador único (Chave Primária)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco vai gerar o ID automaticamente (1, 2, 3...)
    private Long id;

    private String symbol;
    private Double price;
    private LocalDateTime savedAt; // Para sabermos QUANDO essa cotação foi salva

    // Construtor vazio (obrigatório para o Spring/JPA)
    public StockQuote() {
    }

    // Construtor com os dados que vamos preencher
    public StockQuote(String symbol, Double price, LocalDateTime savedAt) {
        this.symbol = symbol;
        this.price = price;
        this.savedAt = savedAt;
    }

    // Getters para podermos ler os dados depois
    public Long getId() { return id; }
    public String getSymbol() { return symbol; }
    public Double getPrice() { return price; }
    public LocalDateTime getSavedAt() { return savedAt; }
}