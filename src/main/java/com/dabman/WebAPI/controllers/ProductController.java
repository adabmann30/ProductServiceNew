package com.dabman.WebAPI.controllers;

import com.dabman.WebAPI.models.Product;
import com.dabman.WebAPI.services.ProductService;
import org.springframework.web.bind.annotation.*;

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
    public Product getProductByid(@PathVariable("id") Long id){

        return productService.getProductByid(id);
    }
    @GetMapping()
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }
    @PutMapping("/{id}")
    public Product ReplaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.ReplaceProduct(id, product);
    }
}
