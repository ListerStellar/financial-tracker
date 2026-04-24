package com.finance_tracker.service;

import com.finance_tracker.dto.CategoryAnalyticsResponse;
import com.finance_tracker.dto.DateRange;
import com.finance_tracker.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final TransactionRepository transactionRepository;

    private DateRange getPeriod(LocalDateTime start, LocalDateTime end) {
        start = (start != null) ? start : LocalDateTime.of(1970, 1, 1, 0, 0);
        end = (end != null) ? end : LocalDateTime.now();
        return new DateRange(start, end);
    }

    public BigDecimal getBalance(LocalDateTime start, LocalDateTime end) {
        DateRange dateRange = getPeriod(start, end);
        BigDecimal income = transactionRepository.getIncome(dateRange);
        BigDecimal expense = transactionRepository.getExpense(dateRange);
        return income.subtract(expense);
    }

    public List<CategoryAnalyticsResponse> getAnalyticsByCategory(LocalDateTime start, LocalDateTime end) {
        return transactionRepository.getAnalyticsByCategory(getPeriod(start, end));
    }
}
