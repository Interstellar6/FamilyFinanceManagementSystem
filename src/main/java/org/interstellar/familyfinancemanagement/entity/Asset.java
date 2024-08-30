package org.interstellar.familyfinancemanagement.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

// 资产管理实体类
@Data
@TableName("asset")
public class Asset {
    @TableId(value = "asset_id", type = IdType.AUTO)
    private Integer assetId;
    private String type;
    private String description;
    private BigDecimal value;
    private Date acquisitionDate;
}
