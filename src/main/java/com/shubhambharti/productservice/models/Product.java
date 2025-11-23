package com.shubhambharti.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Product  extends BaseModel {

    private String title;
    private String description;
    private double price;
    @ManyToOne
    private Category category;
    private String image;


    public Product() {

    }
}
