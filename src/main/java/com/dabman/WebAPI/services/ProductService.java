package com.dabman.WebAPI.services;

import com.dabman.WebAPI.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ProductService {
    Product getProductByid(Long id);
    List<Product> getAllProducts();
    Product ReplaceProduct(Long id, Product product);
}
