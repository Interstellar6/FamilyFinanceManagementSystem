package org.interstellar.familyfinancemanagement.controller;

import org.interstellar.familyfinancemanagement.entity.Result;
import org.interstellar.familyfinancemanagement.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;


    /**
     * 函数：统计指定家庭成员在特定年份和月份的收入
     * 参数：family_id 家庭ID, member_id 家庭成员ID, year 年份, month 月份, category_name 类别名称（可选）
     */
    @GetMapping("/getCategoryRatios")
    public Result<String> getCategoryRatios(
            @RequestParam("familyId") Integer familyId,
            @RequestParam(value = "memberId", required = false) Integer memberId,
            @RequestParam(value = "year", required = false) Integer year,
            @RequestParam(value = "month", required = false) Integer month,
            @RequestParam("type") String type
    ) {
        String ratios = statisticsService.getCategoryRatios(familyId, memberId, year, month, type);
        return Result.success(ratios);
    }

    /**
     *函数：统计指定家庭成员在特定年份和月份的支出
     *参数：family_id 家庭ID, member_id 家庭成员ID, year 年份, month 月份, category_name 类别名称（可选）
     */
    @GetMapping("/getMemberMonthlyExpense")
    public Result<Double> getMemberMonthlyExpense(
            @RequestParam("familyId") Integer familyId,
            @RequestParam("memberId") Integer memberId,
            @RequestParam("year") Integer year,
            @RequestParam("month") Integer month,
            @RequestParam(value = "categoryName", required = false) String categoryName
    ) {
        Double expense = statisticsService.getMemberMonthlyExpense(familyId, memberId, year, month, categoryName);
        return Result.success(expense);
    }

    /**
     * 函数：统计指定家庭成员在特定年份和月份的收入
     * 参数：family_id 家庭ID, member_id 家庭成员ID, year 年份, month 月份, category_name 类别名称（可选）
     */
    @GetMapping("/getMemberMonthlyIncome")
    public Result<Double> getMemberMonthlyIncome(
            @RequestParam("familyId") Integer familyId,
            @RequestParam("memberId") Integer memberId,
            @RequestParam("year") Integer year,
            @RequestParam("month") Integer month,
            @RequestParam(value = "categoryName", required = false) String categoryName
    ) {
        Double income = statisticsService.getMemberMonthlyIncome(familyId, memberId, year, month, categoryName);
        return Result.success(income);
    }

    /**
     *This function will calculate the total income and expense for each category in a specific year,
     *  either for a specific family member or for the entire family.
     */
    @GetMapping("/annual-category-summary")
    public String getAnnualCategorySummary(
            @RequestParam Integer familyId,
            @RequestParam(required = false) Integer memberId,
            @RequestParam Integer year) {
        return statisticsService.getAnnualCategorySummary(familyId, memberId, year);
    }



    // 获取月收入统计数据
    @GetMapping("/monthlyIncomeStatistics")
    public Map<String,Double> getMonthlyIncomeStatistics() {
        return statisticsService.getCurrentMonthlyIncomeStatistics();
    }

    // 获取月支出统计数据
    @GetMapping("/monthlyExpenseStatistics")
    public Map<String,Double> getMonthlyExpenseStatistics() {
        return statisticsService.getCurrentMonthlyExpenseStatistics();
    }

    // 获取年收入统计数据
    @GetMapping("/yearlyIncomeStatistics")
    public Map<String,Double> getYearlyIncomeStatistics() {
        return statisticsService.getCurrentYearlyIncomeStatistics();
    }




}