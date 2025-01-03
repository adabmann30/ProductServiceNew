package com.dabman.WebAPI.controllers;

import com.dabman.WebAPI.models.Category;
import com.dabman.WebAPI.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/categories")
public class CategoryController {
    public CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping()
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
