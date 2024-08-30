package org.interstellar.familyfinancemanagement.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.interstellar.familyfinancemanagement.entity.Expense;
import org.interstellar.familyfinancemanagement.mapper.ExpenseMapper;
import org.interstellar.familyfinancemanagement.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ExpenseServiceImpl extends ServiceImpl<ExpenseMapper, Expense> implements ExpenseService {

    @Autowired
    private ExpenseMapper expenseMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addExpense(Expense expense) {
        return expenseMapper.insert(expense) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateExpense(Expense expense) {
        return expenseMapper.updateById(expense) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteExpense(Integer expenseId) {
        return expenseMapper.deleteById(expenseId) > 0;
    }

    @Override
    public Expense getExpenseById(Integer expenseId) {
        return expenseMapper.selectById(expenseId);
    }

    @Override
    public List<Expense> getExpensesByDateRange(Date startDate, Date endDate) {
        return expenseMapper.selectExpensesByDateRange(startDate, endDate);
    }

    @Override
    public List<Expense> getExpensesByMemberId(Integer memberId) {
        return expenseMapper.selectExpensesByMemberId(memberId);
    }

    @Override
    public List<Expense> getExpensesByCategoryId(Integer categoryId) {
        return expenseMapper.selectExpensesByCategoryId(categoryId);
    }
}

