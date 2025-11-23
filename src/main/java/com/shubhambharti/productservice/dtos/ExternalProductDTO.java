package com.shubhambharti.productservice.dtos;

import com.shubhambharti.productservice.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ExternalProductDTO {

    private long id;
    private String title;
    private double price;
    private String description;
    private Category category;
    private String image;
}
