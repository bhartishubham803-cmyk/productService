package com.shubhambharti.productservice.contollers;


import com.shubhambharti.productservice.dtos.ProductRequestDTO;
import com.shubhambharti.productservice.models.Product;
import com.shubhambharti.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return null;
    }
    @PostMapping("/products")
    public void createProduct(@RequestBody ProductRequestDTO productRequestDTO) {

    }


}
