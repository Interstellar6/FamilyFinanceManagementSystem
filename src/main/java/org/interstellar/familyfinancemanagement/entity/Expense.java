package org.interstellar.familyfinancemanagement.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

// 支出实体类
@Data
@TableName("expense")
public class Expense {
    @TableId(value = "expense_id", type = IdType.AUTO)
    private Integer expenseId;
    private Integer memberId;
    private Integer categoryId;
    private BigDecimal amount;
    private String description;
    private Date expenseDate;
}
