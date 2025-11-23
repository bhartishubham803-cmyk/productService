package com.shubhambharti.productservice.services;

import com.shubhambharti.productservice.dtos.ExternalProductDTO;
import com.shubhambharti.productservice.dtos.FakeStoreProductDTO;
import com.shubhambharti.productservice.exceptions.ProductNotFoundException;
import com.shubhambharti.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class FakeStoreProductService implements ProductService {
    private static final String EXTERNAL_API = "https://fakestoreapi.com/products";

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Product getProductById(int id) throws ProductNotFoundException {
        FakeStoreProductDTO response =restTemplate.getForObject(EXTERNAL_API + "/" + id, FakeStoreProductDTO.class);

        if(response == null) {
            throw new ProductNotFoundException("Product " + id + " not found") ;
        }

        return response.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreProductDTOArray = restTemplate.getForObject(
                EXTERNAL_API, FakeStoreProductDTO[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOArray) {
            products.add(fakeStoreProductDTO.toProduct());
        }
        return products;


    }


}
