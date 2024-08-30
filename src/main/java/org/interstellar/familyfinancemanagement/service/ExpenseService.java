package org.interstellar.familyfinancemanagement;

import org.interstellar.familyfinancemanagement.entity.Expense;

import java.util.List;
import java.util.Date;

public interface ExpenseService {
    // 添加支出记录
    boolean addExpense(Expense expense);

    // 更新支出记录
    boolean updateExpense(Expense expense);

    // 删除支出记录
    boolean deleteExpense(Integer expenseId);

    // 根据ID查询支出记录
    Expense getExpenseById(Integer expenseId);

    // 查询指定时间段的支出记录
    List<Expense> getExpensesByDateRange(Date startDate, Date endDate);

    // 查询指定成员的支出记录
    List<Expense> getExpensesByMemberId(Integer memberId);

    // 查询指定分类的支出记录
    List<Expense> getExpensesByCategoryId(Integer categoryId);
}
