package com.shubhambharti.productservice.services;

import com.shubhambharti.productservice.dtos.FakeStoreProductDTO;
import com.shubhambharti.productservice.exceptions.ProductNotFoundException;
import com.shubhambharti.productservice.models.Category;
import com.shubhambharti.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Product getProductById(long id) throws ProductNotFoundException {
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

    @Override
    public Product createProduct(String title, String description, double price, String categoryName, String imageUrl) {
       FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setCategory(categoryName);
        fakeStoreProductDTO.setImage(imageUrl);
        FakeStoreProductDTO fakeStoreProductDTO1 = restTemplate.postForObject(EXTERNAL_API, fakeStoreProductDTO, FakeStoreProductDTO.class);
        if(fakeStoreProductDTO1 == null) {

        }

        return fakeStoreProductDTO1.toProduct();

    }


}
