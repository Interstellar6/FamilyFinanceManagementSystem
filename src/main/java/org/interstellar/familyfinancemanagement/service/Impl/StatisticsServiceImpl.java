package org.interstellar.familyfinancemanagement.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.interstellar.familyfinancemanagement.entity.Expense;
import org.interstellar.familyfinancemanagement.entity.Income;
import org.interstellar.familyfinancemanagement.mapper.StatisticsMapper;
import org.interstellar.familyfinancemanagement.utils.DateUtils;
import org.interstellar.familyfinancemanagement.mapper.ExpenseMapper;
import org.interstellar.familyfinancemanagement.mapper.IncomeMapper;
import org.interstellar.familyfinancemanagement.service.StatisticsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final IncomeMapper incomeMapper;
    private final ExpenseMapper expenseMapper;
    private final StatisticsMapper statisticsMapper;

    public StatisticsServiceImpl(IncomeMapper incomeMapper, ExpenseMapper expenseMapper, StatisticsMapper statisticsMapper) {
        this.incomeMapper = incomeMapper;
        this.expenseMapper = expenseMapper;
        this.statisticsMapper = statisticsMapper;
    }

    /**
     * 函数：统计指定家庭成员在特定年份和月份的收入
     * 参数：family_id 家庭ID, member_id 家庭成员ID, year 年份, month 月份, category_name 类别名称（可选）
     */
    @Override
    public String getCategoryRatios(Integer familyId, Integer memberId, Integer year, Integer month, String type) {
        return statisticsMapper.getFamilyMemberCategoryRatios(familyId, memberId, year, month, type);
    }

    /**
     *函数：统计指定家庭成员在特定年份和月份的支出
     *参数：family_id 家庭ID, member_id 家庭成员ID, year 年份, month 月份, category_name 类别名称（可选）
     */
    @Override
    public Double getMemberMonthlyExpense(Integer familyId, Integer memberId, Integer year, Integer month, String categoryName) {
        return statisticsMapper.getMemberMonthlyExpense(familyId, memberId, year, month, categoryName);
    }

    /**
     * 函数：统计指定家庭成员在特定年份和月份的收入
     * 参数：family_id 家庭ID, member_id 家庭成员ID, year 年份, month 月份, category_name 类别名称（可选）
     */
    @Override
    public Double getMemberMonthlyIncome(Integer familyId, Integer memberId, Integer year, Integer month, String categoryName) {
        return statisticsMapper.getMemberMonthlyIncome(familyId, memberId, year, month, categoryName);
    }

    /**
     *This function will calculate the total income and expense for each category in a specific year,
     *  either for a specific family member or for the entire family.
     */
    @Override
    public String getAnnualCategorySummary(Integer familyId, Integer memberId, Integer year) {
        return statisticsMapper.getAnnualCategorySummary(familyId, memberId, year);
    }


    @Override
    public Map<String, Double> getCurrentMonthlyIncomeStatistics() {
        // 获取当前年份和当前月份
        int currentYear = Integer.parseInt(DateUtils.getYear());
        int currentMonth = Integer.parseInt(DateUtils.getMonth());

        // 查询当前月份的收入数据
        List<Income> monthlyIncomes = incomeMapper.selectList(new QueryWrapper<Income>()
                .eq("YEAR(income_date)", currentYear)
                .eq("MONTH(income_date)", currentMonth));

        // 创建一个HashMap来存储统计数据
        Map<String, Double> incomeStatistics = new HashMap<>();

        // 计算总收入
        double totalIncome = monthlyIncomes.stream().mapToDouble(Income::getAmount).sum();

        // 添加到HashMap中
        incomeStatistics.put(currentYear + "-" + currentMonth, totalIncome);

        // 返回HashMap
        return incomeStatistics;
    }

    @Override
    public Map<String, Double> getCurrentMonthlyExpenseStatistics() {
        // 获取当前年份和当前月份
        int currentYear = Integer.parseInt(DateUtils.getYear());
        int currentMonth = Integer.parseInt(DateUtils.getMonth());

        // 查询当前月份的支出数据
        List<Expense> monthlyExpenses = expenseMapper.selectList(new QueryWrapper<Expense>()
                .eq("YEAR(expense_date)", currentYear)
                .eq("MONTH(expense_date)", currentMonth));

        // 创建一个HashMap来存储统计数据
        Map<String, Double> expenseStatistics = new HashMap<>();

        // 计算总支出
        Double totalExpense = monthlyExpenses.stream().mapToDouble(Expense::getAmount).sum();

        // 添加到HashMap中
        expenseStatistics.put(currentYear + "-" + currentMonth, totalExpense);

        // 返回HashMap
        return expenseStatistics;
    }

    @Override
    public Map<String,Double> getCurrentYearlyIncomeStatistics() {
        // 获取当前年份
        int currentYear = Integer.parseInt(DateUtils.getYear());

        // 查询当前年份的收入数据
        List<Income> yearlyIncomes = incomeMapper.selectList(new QueryWrapper<Income>()
                .eq("YEAR(income_date)", currentYear));

        // 计算总收入
        double totalIncome = yearlyIncomes.stream().mapToDouble(Income::getAmount).sum();

        Map<String, Double> incomeStatistics = new HashMap<>();
        incomeStatistics.put(currentYear + "-" + currentYear, totalIncome);
        // 返回总收入
        return incomeStatistics;
    }


}


