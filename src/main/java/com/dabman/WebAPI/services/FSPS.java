package com.dabman.WebAPI.services;

import com.dabman.WebAPI.DTOs.FSPDTO;
import com.dabman.WebAPI.models.Category;
import com.dabman.WebAPI.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FSPS implements ProductService{
    private RestTemplate restTemplate;
    FSPS(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    private FSPDTO convertProducttoFSDTO(Product product){
        FSPDTO fspdto = new FSPDTO();
        fspdto.setId(product.getId());
        fspdto.setImage(product.getImage());
        fspdto.setTitle(product.getTitle());
        fspdto.setPrice(product.getPrice());
        fspdto.setDescription(product.getDescription());
        Category category = product.getCategory();
        fspdto.setCategory(category.getDesc());
        return fspdto;
    }
    private Product convertFSDTOtoProduct(FSPDTO dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setDescription(dto.getDescription());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());

        Category category = new Category();
        category.setDesc(dto.getCategory());
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

    @Override
    public Product ReplaceProduct(Long id, Product product) {
        FSPDTO fspdto = convertProducttoFSDTO(product);

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fspdto, FSPDTO.class);
        HttpMessageConverterExtractor<FSPDTO> responseExtractor =
                new HttpMessageConverterExtractor<>(FSPDTO.class, restTemplate.getMessageConverters());
        FSPDTO output = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);

        return convertFSDTOtoProduct(output);
    }
}
