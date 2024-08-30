package org.interstellar.familyfinancemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.interstellar.familyfinancemanagement.entity.UserLogin.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
