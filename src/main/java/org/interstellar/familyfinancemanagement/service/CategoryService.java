package org.interstellar.familyfinancemanagement.service;

import org.interstellar.familyfinancemanagement.entity.Category;
import java.util.List;

public interface CategoryService {
    // 添加收支分类
    boolean addCategory(Category category);

    // 更新收支分类
    boolean updateCategory(Category category);

    // 删除收支分类
    boolean deleteCategory(Integer categoryId);

    // 根据ID查询收支分类
    Category getCategoryById(Integer categoryId);

    // 查询所有收支分类
    List<Category> getAllCategories();
}
