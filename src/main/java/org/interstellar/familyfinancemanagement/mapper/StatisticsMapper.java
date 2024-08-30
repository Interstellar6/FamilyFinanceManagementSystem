package org.interstellar.familyfinancemanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FinanceMapper {

    @Select("SELECT GetFamilyMemberCategoryRatios(#{familyId}, #{memberId}, #{year}, #{month}, #{type})")
    String getFamilyMemberCategoryRatios(
            @Param("familyId") Integer familyId,
            @Param("memberId") Integer memberId,
            @Param("year") Integer year,
            @Param("month") Integer month,
            @Param("type") String type
    );
}
