package com.finance_tracker.repository;

import com.finance_tracker.entity.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Transaction t WHERE t.category.id = :categoryId")
    void deleteAllByCategoryId(@Param("categoryId") Long categoryId);
}
