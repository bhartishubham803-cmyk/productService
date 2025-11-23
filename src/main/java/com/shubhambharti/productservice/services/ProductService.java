package com.shubhambharti.productservice.services;

import com.shubhambharti.productservice.exceptions.ProductNotFoundException;
import com.shubhambharti.productservice.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(int id) throws ProductNotFoundException;
    List<Product> getAllProducts();
}
