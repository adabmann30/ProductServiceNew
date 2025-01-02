package com.dabman.WebAPI.controllers;

import com.dabman.WebAPI.Exceptions.ProductNotFound;
import com.dabman.WebAPI.models.Product;
import com.dabman.WebAPI.services.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> getProductByid(@PathVariable("id") Long id) throws ProductNotFound {
        Product product = productService.getProductByid(id);
        ResponseEntity<Product> responseEntity;
//        if(product==null){
//            responseEntity = new ResponseEntity<>(HttpStatusCode.valueOf(201));
//            return responseEntity;
//        }
        responseEntity = new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
        return responseEntity;
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
