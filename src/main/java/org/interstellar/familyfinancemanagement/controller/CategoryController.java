package org.interstellar.familyfinancemanagement.controller;

import org.interstellar.familyfinancemanagement.entity.Category;
import org.interstellar.familyfinancemanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // 添加收支分类
    @PostMapping("/add")
    public boolean addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    // 更新收支分类
    @PutMapping("/update")
    public boolean updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    // 删除收支分类
    @DeleteMapping("/delete/{categoryId}")
    public boolean deleteCategory(@PathVariable Integer categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

    // 根据ID查询收支分类
    @GetMapping("/get/{categoryId}")
    public Category getCategoryById(@PathVariable Integer categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    // 查询所有收支分类
    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}

