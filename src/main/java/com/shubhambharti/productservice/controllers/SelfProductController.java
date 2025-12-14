package com.shubhambharti.productservice.controllers;

import com.shubhambharti.productservice.dtos.ProductRequestDTO;
import com.shubhambharti.productservice.models.Product;
import com.shubhambharti.productservice.services.SelfProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/selfProduct")
public class SelfProductController {
    @Autowired
     SelfProductService selfProductService;
    @PostMapping("/create")
    public Product createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
       return selfProductService.createProduct(
               productRequestDTO.getTitle(),
               productRequestDTO.getDescription(),
               productRequestDTO.getPrice(),
               productRequestDTO.getCategory(),
               productRequestDTO.getImage()
       );
    }
}
