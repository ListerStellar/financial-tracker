package com.finance_tracker.repository;

import com.finance_tracker.dto.CategoryAnalyticsResponse;
import com.finance_tracker.dto.DateRange;
import com.finance_tracker.entity.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Transaction t WHERE t.category.id = :categoryId")
    void deleteAllByCategoryId(@Param("categoryId") Long categoryId);

    @Query("SELECT COALESCE(SUM(t.amount), 0) FROM Transaction t WHERE t.category.type = 'INCOME' AND t.date BETWEEN :#{#dateRange.start} AND :#{#dateRange.end}")
    BigDecimal getIncome(@Param("dateRange") DateRange dateRange);

    @Query("SELECT COALESCE(SUM(t.amount), 0) FROM Transaction t WHERE t.category.type = 'EXPENSE' AND t.date BETWEEN :#{#dateRange.start} AND :#{#dateRange.end}")
    BigDecimal getExpense(@Param("dateRange") DateRange dateRange);

    @Query("SELECT new com.finance_tracker.dto.CategoryAnalyticsResponse(c.name, c.type, CAST(COALESCE(SUM(t.amount), 0) AS BigDecimal)) " +
            "FROM Category c " +
            "LEFT JOIN Transaction t ON t.category = c AND t.date BETWEEN :#{#dateRange.start} AND :#{#dateRange.end} " +
            "GROUP BY c.id, c.name, c.type")
    List<CategoryAnalyticsResponse> getAnalyticsByCategory(@Param("dateRange") DateRange dateRange);
}
