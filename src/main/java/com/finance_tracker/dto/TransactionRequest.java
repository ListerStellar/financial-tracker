package com.finance_tracker.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionRequest(
        @NotNull(message = "Amount can't be empty")
        @Positive(message = "Amount must be positive")
        BigDecimal amount,

        @NotNull(message = "Category ID required")
        @Positive(message = "Category ID must be positive")
        Long categoryId,

        @Size(max = 255, message = "Description must be less than 256 symbols")
        String description,

        @PastOrPresent(message = "Can't add transaction from future")
        LocalDateTime date
) {
}
