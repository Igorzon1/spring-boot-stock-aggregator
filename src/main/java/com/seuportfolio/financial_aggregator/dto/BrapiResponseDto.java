package com.seuportfolio.financial_aggregator.dto;

import java.util.List;

public record BrapiResponseDto(
        List<StockDto> results
) {}