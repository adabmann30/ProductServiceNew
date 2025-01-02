package com.dabman.WebAPI.services;

import com.dabman.WebAPI.DTOs.FSPDTO;
import com.dabman.WebAPI.models.Category;
import com.dabman.WebAPI.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FSPS implements ProductService{
    private RestTemplate restTemplate;
    FSPS(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    private Product convertFSDTOtoProduct(FSPDTO dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setDescription(dto.getDescription());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());

        Category category = new Category();
        category.setDesc(dto.getDescription());
        category.setId(product.getId());
        product.setCategory(category);

        return product;
    }
    @Override
    public Product getProductByid(Long id) {
        FSPDTO fspdto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FSPDTO.class);
        if(fspdto==null) return null;
        return convertFSDTOtoProduct(fspdto);
    }

    @Override
    public List<Product> getAllProducts() {
        FSPDTO[] fspdtos =
                restTemplate.getForObject("https://fakestoreapi.com/products", FSPDTO[].class);

        List<Product> output = new ArrayList<>();
        for(FSPDTO fspdto : fspdtos){
            output.add(convertFSDTOtoProduct(fspdto));
        }
        return output;
    }
}
