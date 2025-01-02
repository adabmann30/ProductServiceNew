package com.dabman.WebAPI.services;

import com.dabman.WebAPI.Exceptions.ProductNotFound;
import com.dabman.WebAPI.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ProductService {
    Product getProductByid(Long id) throws ProductNotFound;
    List<Product> getAllProducts();
    Product ReplaceProduct(Long id, Product product);
    Void DeleteProduct(Long id);
}
