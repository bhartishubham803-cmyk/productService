package com.shubhambharti.productservice.services;

import com.shubhambharti.productservice.exceptions.ProductNotFoundException;
import com.shubhambharti.productservice.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(int id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(String title, String description, double price, String categoryName, String imageUrl) ;

}
