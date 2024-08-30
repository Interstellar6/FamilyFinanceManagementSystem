package org.interstellar.familyfinancemanagement.service;

import java.util.Map;

public interface StatisticsService {
    /**
     * 函数：统计指定家庭成员在特定年份和月份的收入
     * 参数：family_id 家庭ID, member_id 家庭成员ID, year 年份, month 月份, category_name 类别名称（可选）
     */
    String getCategoryRatios(Integer familyId, Integer memberId, Integer year, Integer month, String type);

    /**
     *函数：统计指定家庭成员在特定年份和月份的支出
     *参数：family_id 家庭ID, member_id 家庭成员ID, year 年份, month 月份, category_name 类别名称（可选）
     */
    Double getMemberMonthlyExpense(Integer familyId, Integer memberId, Integer year, Integer month, String categoryName);

    /**
     * 函数：统计指定家庭成员在特定年份和月份的收入
     * 参数：family_id 家庭ID, member_id 家庭成员ID, year 年份, month 月份, category_name 类别名称（可选）
     */
    Double getMemberMonthlyIncome(Integer familyId, Integer memberId, Integer year, Integer month, String categoryName);

    /**
     *This function will calculate the total income and expense for each category in a specific year,
     *  either for a specific family member or for the entire family.
     */
    String getAnnualCategorySummary(Integer familyId, Integer memberId, Integer year);

    Map<String, Double> getCurrentMonthlyIncomeStatistics();

    Map<String, Double> getCurrentMonthlyExpenseStatistics();

    Map<String,Double> getCurrentYearlyIncomeStatistics();
}

