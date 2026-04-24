package com.finance_tracker.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionRequest(
        BigDecimal amount,
        Long categoryId,
        String description,
        LocalDateTime date
) {
}
