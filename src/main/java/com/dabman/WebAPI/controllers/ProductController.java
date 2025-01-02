package com.dabman.WebAPI.controllers;

import com.dabman.WebAPI.models.Product;
import com.dabman.WebAPI.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    public ProductService productService;

    public ProductController(ProductService productService){

        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){

        return productService.getProductByid(id);
    }
    @GetMapping()
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }
}
