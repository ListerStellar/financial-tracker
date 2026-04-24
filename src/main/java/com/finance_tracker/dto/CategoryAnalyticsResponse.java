package com.finance_tracker.dto;

import com.finance_tracker.entity.TransactionType;
import java.math.BigDecimal;

public record CategoryAnalyticsResponse(
        String categoryName,
        TransactionType type,
        BigDecimal totalAmount
) {
}
