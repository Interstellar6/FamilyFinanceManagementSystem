package org.interstellar.familyfinancemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.interstellar.familyfinancemanagement.entity.Family;

@Mapper
public interface FamilyMapper extends BaseMapper<Family> {
    @Select("select * from FamilyFinanceManagementSystem.family where family_name = #{familyName}")
    Family selectByFamilyName(String familyName);
}
