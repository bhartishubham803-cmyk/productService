package com.shubhambharti.productservice.controllers;


import com.shubhambharti.productservice.dtos.ProductRequestDTO;
import com.shubhambharti.productservice.exceptions.ProductNotFoundException;
import com.shubhambharti.productservice.models.Product;
import com.shubhambharti.productservice.services.FakeStoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FakeProductController {

    @Autowired
    FakeStoreProductService fakeStoreProductService;

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id) throws ProductNotFoundException {


        return fakeStoreProductService.getProductById(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return fakeStoreProductService.getAllProducts();
    }
    @PostMapping("/products")
    Product createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return fakeStoreProductService.createProduct(
                productRequestDTO.getTitle(),
                productRequestDTO.getDescription(),
                productRequestDTO.getPrice(),
                productRequestDTO.getCategory(),
                productRequestDTO.getImage()

        );

    }



    /*
    We got an exception but we don't want to send the stack trace to the client
        1. We can handle the exception in the controller method itself
        2. We can have a global exception handler using @ControllerAdvice
        3. We can have a local exception handler using @ExceptionHandler
     */


}
