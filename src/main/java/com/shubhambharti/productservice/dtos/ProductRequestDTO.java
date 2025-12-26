package com.shubhambharti.productservice.dtos;

import com.shubhambharti.productservice.models.Category;
import lombok.Data;

@Data
public class ProductRequestDTO {

    private String title;
    private double price;
    private String description;
    private Category category;
    private String image;
}
