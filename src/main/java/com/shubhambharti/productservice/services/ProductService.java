package com.shubhambharti.productservice.services;

import com.shubhambharti.productservice.dtos.ExternalProductDTO;
import com.shubhambharti.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    private static final String EXTERNAL_API = "https://fakestoreapi.com/products";

    @Autowired
    private RestTemplate restTemplate;

    public Product getProductById(int id) {
        ExternalProductDTO dto =restTemplate.getForObject(EXTERNAL_API + "/" + id, ExternalProductDTO.class);
        Product mapped=mapToProduct(dto);
        return mapped;
    }

    // Map ExternalProductDTO -> Product
    private Product mapToProduct(ExternalProductDTO dto) {
      if(dto==null){
          return null;
      }
      Product product = new Product();
      /*
      * "id": 0,
        "title": "string",
        "price": 0.1,
        "description": "string",
        "category": "string",
        "image": "http://example.com"
         }
      * */
      product.setId(dto.getId());
      product.setTitle(dto.getTitle());
      product.setDescription(dto.getDescription());
      product.setPrice(dto.getPrice());
      product.setCategory(dto.getCategory());
      product.setImage(dto.getImage());
      return product;
    }

}
