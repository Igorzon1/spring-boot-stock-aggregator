package com.seuportfolio.financial_aggregator.repository;

import com.seuportfolio.financial_aggregator.model.StockQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockQuoteRepository extends JpaRepository<StockQuote, Long> {
    // Só de herdar o JpaRepository, você já ganha métodos como save(), findAll(), findById() de graça!
}