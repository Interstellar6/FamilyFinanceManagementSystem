package org.interstellar.familyfinancemanagement.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

// 家庭成员实体类
@Data
@TableName("family_member")
public class FamilyMember {
    @TableId(value = "member_id", type = IdType.AUTO)
    private Integer memberId;
    private String name;
    private String relation;
    private Date birthDate;
}
