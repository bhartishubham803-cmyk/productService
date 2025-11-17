package com.shubhambharti.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ExternalProductDTO {

    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
}
