package com.seuportfolio.financial_aggregator.dto;

public record StockDto(
        String symbol,
        String shortName,
        Double regularMarketPrice
) {}