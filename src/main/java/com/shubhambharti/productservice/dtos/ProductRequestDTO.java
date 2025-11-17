package com.shubhambharti.productservice.dtos;

import lombok.Data;

@Data
public class ProductRequestDTO {

    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
}
