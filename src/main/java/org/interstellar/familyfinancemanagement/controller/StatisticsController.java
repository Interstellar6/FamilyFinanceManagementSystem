package org.interstellar.familyfinancemanagement.controller;

import org.interstellar.familyfinancemanagement.entity.Expense;
import org.interstellar.familyfinancemanagement.entity.Income;
import org.interstellar.familyfinancemanagement.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    // 获取月收入统计数据
    @GetMapping("/monthlyIncomeStatistics")
    public List<Income> getMonthlyIncomeStatistics() {
        return statisticsService.getMonthlyIncomeStatistics();
    }

    // 获取月支出统计数据
    @GetMapping("/monthlyExpenseStatistics")
    public List<Expense> getMonthlyExpenseStatistics() {
        return statisticsService.getMonthlyExpenseStatistics();
    }

    // 获取年收入统计数据
    @GetMapping("/yearlyIncomeStatistics")
    public List<Income> getYearlyIncomeStatistics() {
        return statisticsService.getYearlyIncomeStatistics();
    }

    // 获取年支出统计数据
    @GetMapping("/yearlyExpenseStatistics")
    public List<Expense> getYearlyExp