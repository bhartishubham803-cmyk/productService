package com.shubhambharti.productservice.controllers;

import com.shubhambharti.productservice.dtos.ProductRequestDTO;
import com.shubhambharti.productservice.exceptions.ProductNotFoundException;
import com.shubhambharti.productservice.models.Product;
import com.shubhambharti.productservice.services.ProductService;
import com.shubhambharti.productservice.services.SelfProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/selfProduct")
public class SelfProductController {


    private final ProductService productService;

    public SelfProductController( @Qualifier("selfProductService")ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getSingleProduct(@PathVariable("id")Long id) throws ProductNotFoundException {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/get")
    public List<Product> getAllSelfProducts() {
        return productService.getAllProducts();
    }
    @PostMapping("/create")
    public Product createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
       return productService.createProduct(
               productRequestDTO.getTitle(),
               productRequestDTO.getDescription(),
               productRequestDTO.getPrice(),
               productRequestDTO.getCategoryName(),
               productRequestDTO.getImage()
       );
    }
}
