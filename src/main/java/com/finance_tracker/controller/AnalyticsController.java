package com.finance_tracker.controller;

import com.finance_tracker.dto.CategoryAnalyticsResponse;
import com.finance_tracker.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/balance")
    public BigDecimal getBalance(@RequestParam(required = false) LocalDateTime start,
                                 @RequestParam(required = false) LocalDateTime end) {
        return analyticsService.getBalance(start, end);
    }

    @GetMapping("/by-category")
    public List<CategoryAnalyticsResponse> getAnalyticsByCategory(@RequestParam(required = false) LocalDateTime start,
                                                                  @RequestParam(required = false) LocalDateTime end) {
        return analyticsService.getAnalyticsByCategory(start, end);
    }
}
