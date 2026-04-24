package com.finance_tracker.controller;

import com.finance_tracker.dto.TransactionRequest;
import com.finance_tracker.entity.Transaction;
import com.finance_tracker.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public Transaction createTransaction(@Valid @RequestBody TransactionRequest request) {
        return transactionService.createTransaction(request);
    }

    @DeleteMapping("/{transactionId}")
    public void deleteTransactionById(@PathVariable Long transactionId) {
        transactionService.deleteTransactionById(transactionId);
    }
}
