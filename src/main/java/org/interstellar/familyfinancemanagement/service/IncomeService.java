package org.interstellar.familyfinancemanagement.service;

import org.interstellar.familyfinancemanagement.entity.Income;

import java.util.Date;
import java.util.List;

public interface IncomeService {
    // 添加收入记录
    boolean addIncome(Income income);

    // 更新收入记录
    boolean updateIncome(Income income);

    // 删除收入记录
    boolean deleteIncome(Integer incomeId);

    // 根据ID查询收入记录
    Income getIncomeById(Integer incomeId);

    // 查询指定时间段的收入记录
    List<Income> getIncomesByDateRange(Date startDate, Date endDate);

    // 查询指定成员的收入记录
    List<Income> getIncomesByMemberId(Integer memberId);
}
