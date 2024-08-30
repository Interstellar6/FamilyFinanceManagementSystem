package org.interstellar.familyfinancemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.interstellar.familyfinancemanagement.entity.Asset;

import java.util.List;

@Mapper
public interface AssetMapper extends BaseMapper<Asset> {
    @Select("select * from FamilyFinanceManagementSystem.asset where member_id = #{memberId}")
    List<Asset> selectByLaucherId(Integer memberId);
}
