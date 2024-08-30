package org.interstellar.familyfinancemanagement.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;

// 收入实体类
@Data
@TableName("income")
public class Income {
    @TableId(value = "income_id", type = IdType.AUTO)
    private Integer incomeId;
    private Integer familyId;
    private Integer memberId;
    private Long amount;
    private String category;
    private Date incomeDate;


}
