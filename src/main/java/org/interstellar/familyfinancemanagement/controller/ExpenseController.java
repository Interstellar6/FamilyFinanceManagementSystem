package org.interstellar.familyfinancemanagement.controller;

import org.interstellar.familyfinancemanagement.entity.Expense;
import org.interstellar.familyfinancemanagement.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // 添加支出记录
    @PostMapping("/add")
    public boolean addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    // 更新支出记录
    @PutMapping("/update")
    public boolean updateExpense(@RequestBody Expense expense) {
        return expenseService.updateExpense(expense);
    }

    // 删除支出记录
    @DeleteMapping("/delete/{expenseId}")
    public boolean deleteExpense(@PathVariable Integer expenseId) {
        return expenseService.deleteExpense(expenseId);
    }

    // 根据ID查询支出记录
    @GetMapping("/get/{expenseId}")
    public Expense getExpenseById(@PathVariable Integer expenseId) {
        return expenseService.getExpenseById(expenseId);
    }

    // 查询指定时间段的支出记录
    @GetMapping("/getByDateRange")
    public List<Expense> getExpensesByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
        return expenseService.getExpensesByDateRange(startDate, endDate);
    }

    // 查询指定成员的支出记录
    @GetMapping("/getByMemberId")
    public List<Expense> getExpensesByMemberId(@RequestParam Integer memberId) {
        return expenseService.getExpensesByMemberId(memberId);
    }
}


