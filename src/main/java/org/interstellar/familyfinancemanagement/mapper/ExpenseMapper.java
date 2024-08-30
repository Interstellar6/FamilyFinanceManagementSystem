package org.interstellar.familyfinancemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.interstellar.familyfinancemanagement.entity.Expense;

import java.util.Date;
import java.util.List;

@Mapper
public interface ExpenseMapper extends BaseMapper<Expense> {
    // 查询指定成员的支出记录
    @Select("select * from FamilyFinanceManagementSystem.expense where member_id = #{memberId}")
    List<Expense> selectExpensesByMemberId(@Param("memberId") Integer memberId);

    // 查询指定分类的支出记录
    @Select("select * from FamilyFinanceManagementSystem.expense where expense.category_id = #{categoryId}")
    List<Expense> selectExpensesByCategoryId(@Param("categoryId") Integer categoryId);

    // 查询指定时间段的支出记录
    @Select("select * from FamilyFinanceManagementSystem.expense where expense.expense_date between #{startDate} and #{endDate}")
    List<Expense> selectExpensesByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
