package org.interstellar.familyfinancemanagement.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.interstellar.familyfinancemanagement.entity.Income;
import org.interstellar.familyfinancemanagement.mapper.IncomeMapper;
import org.interstellar.familyfinancemanagement.service.IncomeService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IncomeServiceImpl extends ServiceImpl<IncomeMapper, Income> implements IncomeService {

    @Override
    public boolean addIncome(Income income) {
        return super.save(income);
    }

    @Override
    public boolean updateIncome(Income income) {
        return super.updateById(income);
    }

    @Override
    public boolean deleteIncome(Integer incomeId) {
        return super.removeById(incomeId);
    }

    @Override
    public Income getIncomeById(Integer incomeId) {
        return super.getById(incomeId);
    }

    @Override
    public List<Income> getIncomesByDateRange(Date startDate, Date endDate) {
        return super.listByMap(null);
    }

    @Override
    public List<Income> getIncomesByMemberId(Integer memberId) {
        return super.listByMap(null);
    }
}
