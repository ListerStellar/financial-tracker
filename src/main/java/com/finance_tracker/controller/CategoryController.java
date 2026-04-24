package com.finance_tracker.controller;

import com.finance_tracker.entity.Category;
import com.finance_tracker.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategoryById (@PathVariable Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
    }
}
