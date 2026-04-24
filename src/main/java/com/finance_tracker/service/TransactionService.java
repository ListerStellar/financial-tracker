package com.finance_tracker.service;

import com.finance_tracker.dto.TransactionRequest;
import com.finance_tracker.repository.CategoryRepository;
import com.finance_tracker.repository.TransactionRepository;
import com.finance_tracker.entity.Category;
import com.finance_tracker.entity.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction createTransaction(TransactionRequest request) {
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new RuntimeException("Category with ID " + request.categoryId() + " not found"));

        Transaction transaction = Transaction.builder()
                .amount(request.amount())
                .date(request.date() != null ? request.date() : LocalDateTime.now())
                .category(category)
                .description(request.description())
                .build();

        return transactionRepository.save(transaction);
    }

    public void deleteTransactionById(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }

    public void deleteAllByCategoryId(Long categoryId) {
        transactionRepository.deleteAllByCategoryId(categoryId);
    }
}
