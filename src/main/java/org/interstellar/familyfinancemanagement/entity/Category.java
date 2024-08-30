package org.interstellar.familyfinancemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author interstellar
 */
// 收支分类实体类
@Data
@TableName("category")
public class Category {
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;
    private String name;
    private Integer parentCategoryId;
}

