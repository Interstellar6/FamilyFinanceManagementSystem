package org.interstellar.familyfinancemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author interstellar
 */
// 支出实体类
@Data
@TableName("expense")
public class Expense {
    @TableId(value = "expense_id", type = IdType.AUTO)
    private Integer expenseId;
    private Integer memberId;
    private Integer familyId;
    private String category;
    private Long amount;
    private String description;
    private Date expenseDate;
}

