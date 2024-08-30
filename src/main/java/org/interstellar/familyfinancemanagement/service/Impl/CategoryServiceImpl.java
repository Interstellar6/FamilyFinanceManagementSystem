package org.interstellar.familyfinancemanagement.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.interstellar.familyfinancemanagement.entity.Category;
import org.interstellar.familyfinancemanagement.mapper.CategoryMapper;
import org.interstellar.familyfinancemanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addCategory(Category category) {
        return categoryMapper.insert(category) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateCategory(Category category) {
        return categoryMapper.updateById(category) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteCategory(Integer categoryId) {
        return categoryMapper.deleteById(categoryId) > 0;
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryMapper.selectById(categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryMapper.selectList(null);
    }
}

