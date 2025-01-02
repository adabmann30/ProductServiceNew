package com.dabman.WebAPI.services;

import com.dabman.WebAPI.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ProductService {
    public Product getProductByid(int id);
    public List<Product> getAllProducts();
}