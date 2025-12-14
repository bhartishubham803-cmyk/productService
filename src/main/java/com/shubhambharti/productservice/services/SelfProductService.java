package com.shubhambharti.productservice.services;

import com.shubhambharti.productservice.exceptions.ProductNotFoundException;
import com.shubhambharti.productservice.models.Category;
import com.shubhambharti.productservice.models.Product;
import com.shubhambharti.productservice.repositories.CategoryRepository;
import com.shubhambharti.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Product getProductById(int id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String description, double price, String categoryName, String imageUrl) {
        Category category = categoryRepository.findByName(categoryName);


        if (category == null) {
            category = new Category();
            category.setName(categoryName);
            categoryRepository.save(category);
        }


        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategory(category);
        product.setImage(imageUrl);

        return productRepository.save(product);

    }
}
