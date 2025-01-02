package com.dabman.WebAPI.services;

import com.dabman.WebAPI.models.Category;
import com.dabman.WebAPI.models.Product;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories();
    public List<Product> getInCategory(Category category);

}
