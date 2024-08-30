package org.interstellar.familyfinancemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.UUID;

@Data
@TableName("family")
public class Family {
    @TableId(value = "family_id", type = IdType.AUTO)
    Integer familyId;
    Integer num;
    String familyName;
    String activateCode;
    String description;

    public Family(String familyName){
        this.familyName = familyName;
        num = 0;
        activateCode = UUID.randomUUID().toString();
        description = "";
    }

}
