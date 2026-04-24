package com.finance_tracker.service;

import com.finance_tracker.entity.Category;
import com.finance_tracker.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final TransactionService transactionService;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @org.springframework.transaction.annotation.Transactional
    public void deleteCategoryById(Long categoryId) {
        transactionService.deleteAllByCategoryId(categoryId);
        categoryRepository.deleteById(categoryId);
    }
}
