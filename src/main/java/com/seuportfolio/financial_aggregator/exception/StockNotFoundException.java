package com.seuportfolio.financial_aggregator.exception;

// Estender RuntimeException significa que esta é uma exceção que acontece enquanto o programa roda
public class StockNotFoundException extends RuntimeException {

    public StockNotFoundException(String message) {
        super(message); // Repassa a mensagem de erro para o Java
    }
}