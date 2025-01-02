package com.dabman.WebAPI.services;

import com.dabman.WebAPI.models.Category;
import com.dabman.WebAPI.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FSCS implements CategoryService{
    private RestTemplate restTemplate;
    FSCS(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Category> getAllCategories() {
        String[] FScats=
                restTemplate.getForObject("https://fakestoreapi.com/products/categories", String[].class);
        List<Category> output = new ArrayList<>();
        for(String FScat : FScats){
            Category category = new Category();
            category.setDesc(FScat);
            output.add(category);
        }
        return output;
    }

    @Override
    public List<Product> getInCategory(Category category) {
        return List.of();
    }
}
