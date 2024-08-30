package org.interstellar.familyfinancemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

// 资产管理实体类
@Data
@TableName("asset")
public class Asset {
    @TableId(value = "asset_id", type = IdType.AUTO)
    private Integer assetId;
    private Integer familyId;
    private Integer memberId;
    private String category;
    private String description;
    private Long value;
    private Date acquisitionDate;

    Asset(Integer familyId, Integer memberId, String category, Long value, Date acquisitionDate) {
        this.familyId = familyId;
        this.memberId = memberId;
        this.category = category;
        this.value = value;
        this.acquisitionDate = acquisitionDate;
    }

    Asset(Income income){
        this.familyId = income.getFamilyId();
        this.memberId = income.getMemberId();
        this.category = income.getCategory();
        this.value = income.getAmount();
        this.acquisitionDate = income.getIncomeDate();
    }

    Asset(Expense expense){
        this.familyId = expense.getFamilyId();
        this.memberId = expense.getMemberId();
        this.category = expense.getCategory();
        this.value = - expense.getAmount();
        this.acquisitionDate = expense.getExpenseDate();
    }


}
