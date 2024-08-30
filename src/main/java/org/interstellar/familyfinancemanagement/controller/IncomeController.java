package org.interstellar.familyfinancemanagement.controller;

import org.interstellar.familyfinancemanagement.entity.Income;
import org.interstellar.familyfinancemanagement.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/incomes")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    // 添加收入记录
    @PostMapping("/add")
    public boolean addIncome(@RequestBody Income income) {
        return incomeService.addIncome(income);
    }

    // 更新收入记录
    @PutMapping("/update")
    public boolean updateIncome(@RequestBody Income income) {
        return incomeService.updateIncome(income);
    }

    // 删除收入记录
    @DeleteMapping("/delete/{incomeId}")
    public boolean deleteIncome(@PathVariable Integer incomeId) {
        return incomeService.deleteIncome(incomeId);
    }

    // 根据ID查询收入记录
    @GetMapping("/get/{incomeId}")
    public Income getIncomeById(@PathVariable Integer incomeId) {
        return incomeService.getIncomeById(incomeId);
    }

    // 查询指定时间段的收入记录
    @GetMapping("/getByDateRange")
    public List<Income> getIncomesByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
        return incomeService.getIncomesByDateRange(startDate, endDate);
    }

    // 查询指定成员的收入记录
    @GetMapping("/getByMemberId")
    public List<Income> getIncomesByMemberId(@RequestParam Integer memberId) {
        return incomeService.getIncomesByMemberId(memberId);
    }
}