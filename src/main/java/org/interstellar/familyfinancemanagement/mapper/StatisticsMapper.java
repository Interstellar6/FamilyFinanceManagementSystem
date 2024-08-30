package org.interstellar.familyfinancemanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StatisticsMapper {

    /**
     * 函数：统计指定家庭成员在特定年份和月份的收入
     * 参数：family_id 家庭ID, member_id 家庭成员ID, year 年份, month 月份, category_name 类别名称（可选）
     */
    @Select("SELECT GetFamilyMemberCategoryRatios(#{familyId}, #{memberId}, #{year}, #{month}, #{type})")
    String getFamilyMemberCategoryRatios(
            @Param("familyId") Integer familyId,
            @Param("memberId") Integer memberId,
            @Param("year") Integer year,
            @Param("month") Integer month,
            @Param("type") String type
    );

    /**
     *函数：统计指定家庭成员在特定年份和月份的支出
     *参数：family_id 家庭ID, member_id 家庭成员ID, year 年份, month 月份, category_name 类别名称（可选）
     */
    @Select("SELECT GetMemberMonthlyExpense(#{familyId}, #{memberId}, #{year}, #{month}, #{categoryName})")
    Double getMemberMonthlyExpense(
            @Param("familyId") Integer familyId,
            @Param("memberId") Integer memberId,
            @Param("year") Integer year,
            @Param("month") Integer month,
            @Param("categoryName") String categoryName
    );

    /**
     * 函数：统计指定家庭成员在特定年份和月份的收入
     * 参数：family_id 家庭ID, member_id 家庭成员ID, year 年份, month 月份, category_name 类别名称（可选）
     */
    @Select("SELECT GetMemberMonthlyIncome(#{familyId}, #{memberId}, #{year}, #{month}, #{categoryName})")
    Double getMemberMonthlyIncome(
            @Param("familyId") Integer familyId,
            @Param("memberId") Integer memberId,
            @Param("year") Integer year,
            @Param("month") Integer month,
            @Param("categoryName") String categoryName
    );

    @Select("SELECT GetAnnualCategorySummary(#{familyId}, #{memberId}, #{year})")
    String getAnnualCategorySummary(
            @Param("familyId") Integer familyId,
            @Param("memberId") Integer memberId,
            @Param("year") Integer year
    );
}
