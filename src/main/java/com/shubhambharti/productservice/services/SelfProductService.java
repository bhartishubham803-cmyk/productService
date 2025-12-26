package com.shubhambharti.productservice.services;

import com.shubhambharti.productservice.exceptions.ProductNotFoundException;
import com.shubhambharti.productservice.models.Category;
import com.shubhambharti.productservice.models.Product;
import com.shubhambharti.productservice.repositories.CategoryRepository;
import com.shubhambharti.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfProductService implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }




    @Override
    public Product createProduct(String title,
                                 String description,
                                 double price,
                                 Category category, String imageUrl) {

        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImage(imageUrl);

        if (category.getId() != null) {
            Optional<Category> categoryOptional = categoryRepository.findById(category.getId());
            if(categoryOptional.isEmpty()){
                //exception
            }
            product.setCategory(categoryOptional.get());
        }
        else {
           Optional<Category>  categoryOptional = Optional.ofNullable(categoryRepository.findByName(category.getName()));
           if(categoryOptional.isPresent()){
               product.setCategory(categoryOptional.get());
           }
           else{
               Category c = new Category();
               c.setName(category.getName());
               c=categoryRepository.save(c);
               product.setCategory(c);
           }
        }
        return productRepository.save(product);
    }



    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
